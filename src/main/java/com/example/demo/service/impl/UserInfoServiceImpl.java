package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.mbg.mapper.UserInfoMapper;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.mbg.model.UserInfoExample;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.RedisUtil;
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
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisUtil redisUtil;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.selectByExample(new UserInfoExample());
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) {
        if(Objects.equals(oldPassword,newPassword)) Asserts.fail("新旧密码不能一致");
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if(CollUtil.isEmpty(list)) Asserts.fail("不存在该用户名");
        UserInfo record = list.get(0);
        if(!passwordEncoder.matches(oldPassword, record.getPassword())) Asserts.fail("旧密码不匹配");
        record.setPassword(passwordEncoder.encode(newPassword));
        userInfoMapper.updateByPrimaryKey(record);
//        Asserts.fail("Intentional error");    // @Transactional的注解下会使事务回滚
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(list)) return list.get(0);
        return null;
    }

    @Override
    public UserInfo getUserByEmail(String emailAddress) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andEmailEqualTo(emailAddress);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(list)) return list.get(0);
        return null;
    }

    @Override
    public void resetPassword(String emailAddress, String captcha, String newPassword) {
        UserInfo userInfo = this.getUserByEmail(emailAddress);
        if(userInfo == null) Asserts.fail("No account connected to this email!");
        String key = CAPTCHA_EMAIL_ADDRESS + emailAddress;
        if(!redisUtil.hasKey(key)) Asserts.fail("Get a captcha first!");
        if (!redisUtil.stringGet(key).equals(captcha)) Asserts.fail("Wrong captcha!");
        redisUtil.delete(key);
        userInfo.setPassword(passwordEncoder.encode(newPassword));
        userInfoMapper.updateByPrimaryKey(userInfo);
    }


}
