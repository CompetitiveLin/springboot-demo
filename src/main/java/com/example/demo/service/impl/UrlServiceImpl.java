package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UrlMapper;
import com.example.demo.mbg.model.Url;
import com.example.demo.service.RedisService;
import com.example.demo.service.UrlService;
import com.example.demo.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.demo.constant.RedisKeyConstant.url.SHORT_URL_PREFIX;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {


    private final UrlMapper urlMapper;

    private final RedisService redisService;

    private final RBloomFilter<Object> bloomFilter;

    //自定义长链接防重复字符串
    private static final String DUPLICATE = "*";

    //最近使用的短链接缓存过期时间(秒)
    private static final long TIMEOUT = 10 * 60;


    @Override
    public String generate(String longUrl) {
        String shortUrl = HashUtil.hashToBase62(longUrl);
        if (bloomFilter.contains(shortUrl)) {

        } else {
            Url url = new Url();
            url.setSurl(shortUrl);
            url.setLurl(longUrl);
            url.setCreateTime(new Date());
            urlMapper.insert(url);
            String key = SHORT_URL_PREFIX + shortUrl;
            redisService.set(key, longUrl, TIMEOUT);
            bloomFilter.add(shortUrl);
        }
        return shortUrl;
    }

}
