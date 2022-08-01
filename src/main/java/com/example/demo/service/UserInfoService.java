package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.mbg.model.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getAll();

    @Transactional
    int updatePassword(String username, String oldPassword, String newPassword);

    UserInfo getUserByUsername(String username);

}
