package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.mbg.mapper.UrlMapper;
import com.example.demo.mbg.model.Url;
import com.example.demo.service.RedisService;
import com.example.demo.service.UrlService;
import com.example.demo.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.example.demo.constant.RedisKeyConstant.url.SHORT_URL_PREFIX;
import static com.example.demo.constant.RedissonConstant.VIEW_INCREASING_KEY;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {


    private final UrlMapper urlMapper;

    private final RedisService redisService;

    private final RedissonClient redissonClient;

    private final RBloomFilter<Object> bloomFilter;

    //自定义长链接防重复字符串
    private static final String DUPLICATE = "*";

    //最近使用的短链接缓存过期时间(秒)
    private static final long TIMEOUT = 24 * 60 * 60;


    @Transactional
    public void increaseViews(String shortUrl) {
        RLock rLock = redissonClient.getLock(VIEW_INCREASING_KEY + shortUrl);
        rLock.lock();
        UpdateWrapper<Url> updateWrapper = Wrappers.update();
        updateWrapper.lambda().eq(Url::getSurl, shortUrl);
        updateWrapper.setSql("views = views + 1");
        urlMapper.update(null, updateWrapper);
        rLock.unlock();
    }


    @Override
    @Transactional
    public String getLongUrl(String shortUrl) {
        String key = SHORT_URL_PREFIX + shortUrl;
        String longUrl = (String) redisService.get(key);
        if (longUrl != null) {
            redisService.expire(key, TIMEOUT);
            increaseViews(shortUrl);
            return longUrl;
        }
        QueryWrapper<Url> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Url::getSurl, shortUrl);
        Url url = urlMapper.selectOne(queryWrapper);
        if (url != null) {
            longUrl = url.getLurl();
            redisService.set(key, longUrl, TIMEOUT);
            increaseViews(shortUrl);
            return longUrl;
        }
        return null;
    }

    @Override
    public String generate(String longUrl) {
        String shortUrl = HashUtil.hashToBase62(longUrl);
        String key = SHORT_URL_PREFIX + shortUrl;
        if (bloomFilter.contains(shortUrl)) {
            // Retrieve from redis
            if (redisService.hasKey(key)) {
                redisService.expire(key, TIMEOUT);
                return shortUrl;
            }
            // Retrieve from mysql
            QueryWrapper<Url> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(Url::getSurl, shortUrl);
            Url url = urlMapper.selectOne(queryWrapper);
            if (url != null) {
                redisService.set(key, longUrl, TIMEOUT);
                return url.getSurl();
            }
            // Bloom filter false positive,then hash loop.
            StringBuilder sb = new StringBuilder(longUrl);
            while (bloomFilter.contains(shortUrl)) {
                sb.append(DUPLICATE);
                shortUrl = HashUtil.hashToBase62(sb.toString());
            }
        }
        Url url = new Url();
        url.setSurl(shortUrl);
        url.setLurl(longUrl);
        url.setCreateTime(new Date());
        urlMapper.insert(url);
        redisService.set(SHORT_URL_PREFIX + shortUrl, longUrl, TIMEOUT);
        bloomFilter.add(shortUrl);

        return shortUrl;
    }

}
