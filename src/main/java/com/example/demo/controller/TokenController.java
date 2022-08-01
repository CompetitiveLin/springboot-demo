package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/refreshToken",  method = RequestMethod.GET)
    public CommonResult refresh(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        String newToken = tokenService.refreshToken(token);
        Map<String, String> map = new HashMap<>();
        map.put("token", newToken);
        return CommonResult.success(map);
    }
}
