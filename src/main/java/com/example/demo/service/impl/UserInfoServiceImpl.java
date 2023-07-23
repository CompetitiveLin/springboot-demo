package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.exception.Asserts;
import com.example.demo.mbg.mapper.UserInfoMapper;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.demo.constant.RedisKeyConstant.captcha.CAPTCHA_EMAIL_ADDRESS;

@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisService redisService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.selectList(null);
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) {
        if (Objects.equals(oldPassword, newPassword)) Asserts.fail("新旧密码不能一致");
        UserInfo userInfo = getUserByUsername(username);
        if (!passwordEncoder.matches(oldPassword, userInfo.getPassword())) Asserts.fail("旧密码不匹配");
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserInfo::getUsername, username).set(UserInfo::getPassword, passwordEncoder.encode(newPassword));
        userInfoMapper.update(null, updateWrapper);

//        Asserts.fail("Intentional error");    // @Transactional的注解下会使事务回滚
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUsername, username);
        return userInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public UserInfo getUserByEmail(String emailAddress) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getEmail, emailAddress);
        return userInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public void resetPassword(String emailAddress, String captcha, String newPassword) {
        UserInfo userInfo = this.getUserByEmail(emailAddress);
        if (userInfo == null) Asserts.fail("No account is connected to this email!");
        String key = CAPTCHA_EMAIL_ADDRESS + emailAddress;
        if (!redisService.hasKey(key)) Asserts.fail("Get a captcha first!");
        if (!redisService.get(key).equals(captcha)) Asserts.fail("Wrong captcha!");
        redisService.delete(key);
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserInfo::getEmail, emailAddress).set(UserInfo::getPassword, passwordEncoder.encode(newPassword));
        userInfoMapper.update(null, updateWrapper);
    }


}
