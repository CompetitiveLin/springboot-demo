package com.example.demo.controller;

import com.example.demo.response.CommonResult;
import com.example.demo.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.constant.AuthorizationConstant.HEADER_NAME;
import static com.example.demo.constant.AuthorizationConstant.HEADER_PREFIX;

@Tag(name = "TokenController", description = "Token管理")
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Operation(description = "刷新Token")
    @RequestMapping(value = "/refresh-token",  method = RequestMethod.POST)
    public CommonResult<Map<String, String>> refresh(HttpServletRequest request){
        String token = request.getHeader(HEADER_NAME);
        String newToken = HEADER_PREFIX + tokenService.refreshToken(token);
        Map<String, String> map = new HashMap<>();
        map.put("token", newToken);
        return CommonResult.success(map);
    }
}
