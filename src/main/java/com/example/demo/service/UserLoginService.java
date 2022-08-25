package com.example.demo.service;

import com.example.demo.dto.LoginDto;

public interface UserLoginService {
    String login(LoginDto loginDto);

    void insertLog(Long userId, String browser, String platform, String ip, String os);

    String wxLogin(String code);
}
