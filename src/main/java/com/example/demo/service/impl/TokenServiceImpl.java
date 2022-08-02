package com.example.demo.service.impl;

import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;


    @Override
    public String refreshToken(String token) {
        if(!jwtUtil.isNotExpiredToken(token)) Asserts.fail("Token已过期");
        else if(!jwtUtil.verifyToken(token)) Asserts.fail("Invalid Token");
        String newToken = jwtUtil.refreshToken(token);
        redisUtil.stringSet("token:" + jwtUtil.getUserNameToken(newToken), newToken, JWT_EXPIRATION);
        return newToken;
    }
}
