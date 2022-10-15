package com.example.demo.service.impl;

import com.example.demo.util.JwtUtil;
import com.example.demo.util.RedisUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;


    @Override
    public String refreshToken(String token) {
        if(!JwtUtil.isNotExpiredToken(token)) Asserts.fail("Token已过期");
        else if(!JwtUtil.verifyToken(token)) Asserts.fail("Invalid Token");
        String newToken = JwtUtil.refreshToken(token);
        redisUtil.stringSet("token:" + JwtUtil.getUserNameToken(newToken), newToken, JWT_EXPIRATION);
        return newToken;
    }
}
