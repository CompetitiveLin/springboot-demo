package com.example.demo.service.impl;

import com.example.demo.service.RedisService;
import com.example.demo.util.JwtUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.demo.constant.AuthorizationConstant.HEADER_PREFIX;
import static com.example.demo.constant.RedisKeyConstant.token.TOKEN_USERNAME;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;

    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;

    @Override
    public String refreshToken(String token) {
        token = token.substring(HEADER_PREFIX.length());    // The part after "Bearer "
        if(!JwtUtil.isNotExpiredToken(token)) Asserts.fail("Token已过期");
        else if(!JwtUtil.verifyToken(token)) Asserts.fail("Invalid Token");
        String newToken = JwtUtil.refreshToken(token);

        // 为方便查看，存入redis中，但其实没必要存到redis中
        String key = TOKEN_USERNAME + JwtUtil.getUserNameToken(newToken);
        redisService.set(key, newToken, JWT_EXPIRATION);

        return newToken;
    }
}
