package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mbg.model.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserInfoService extends IService<UserInfo> {
    List<UserInfo> getAll();

    @Transactional
    void updatePassword(String username, String oldPassword, String newPassword);

    UserInfo getUserByUsername(String username);

    UserInfo getUserByEmail(String emailAddress);

    void resetPassword(String emailAddress, String captcha, String newPassword);

}
