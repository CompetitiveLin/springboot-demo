package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.demo.mbg.mapper.UserInfoMapper;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.mbg.model.UserInfoExample;
import com.example.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.selectByExample(new UserInfoExample());
    }

    @Override
    public int updatePassword(String username, String oldPassword, String newPassword) {
        if(Objects.equals(oldPassword,newPassword)) return -3;
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if(CollUtil.isEmpty(list)) return -1;
        UserInfo record = list.get(0);
        if(!Objects.equals(record.getPassword(), oldPassword)) return -2;
        record.setPassword(passwordEncoder.encode(newPassword));
        userInfoMapper.updateByPrimaryKey(record);
        return 1;
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(list)) return list.get(0);
        return null;
    }



}
