package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.LoginDto;
import com.example.demo.mbg.model.UserLoginLog;

public interface UserLoginLogService extends IService<UserLoginLog> {
    String login(LoginDto loginDto);

    void insertLog(Long userId, String browser, String platform, String ip, String os);

    String wxLogin(String code);
}
