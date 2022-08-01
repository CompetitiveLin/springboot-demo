package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.component.RedisUtil;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UpdatePasswordDto;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserLoginService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@Api(tags = "it's a test")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 参数用表单登录，没有@RequestBody注解
     * @param loginDto
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("用户登录")
    public CommonResult login(LoginDto loginDto){
        String token = userLoginService.login(loginDto);
        if(token == null) return CommonResult.failed("用户名或密码不正确");  // 根据ServiceImpl里的内容，token永远不可能为null，要么已经抛异常，要么返回正确的token
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ApiOperation(value = "getAll方法", notes = "查询所有用户")
    @PreAuthorize("hasAuthority('admin')")
    public CommonResult getUser(){
        //日志级别从小到大为 trace < debug < info < warn < error < fatal,由于默认日志级别设置为 INFO，因此 trace 和 debug 级别的日志都看不到。
        log.trace("Trace 日志...");
        log.debug("Debug 日志...");
        log.info("Info 日志...");
        log.warn("Warn 日志...");
        log.error("Error 日志...");
        List<UserInfo> list = userInfoService.getAll();
        return CommonResult.success(list);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("update password")
    public CommonResult updatePassword(@Validated @RequestBody UpdatePasswordDto updatePasswordDto){   //当UpdatePasswordDto里的参数不符合要求时，会抛出BindingException的异常，接着会被全局异常捕捉器捕捉，返回异常消息
        int count = userInfoService.updatePassword(updatePasswordDto.getUsername(), updatePasswordDto.getOldPassword(), updatePasswordDto.getNewPassword());
        if(count == -1) return CommonResult.failed("不存在该用户名");
        else if(count == -2) return CommonResult.failed("旧密码不匹配");
        else if(count == -3) return CommonResult.failed("新旧密码不能一致");
        return CommonResult.success();
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    @ApiOperation("test redis")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "键", dataTypeClass = String.class),
            @ApiImplicitParam(name = "value", value = "值", dataTypeClass= String.class),
            @ApiImplicitParam(name = "time", value = "时间", dataTypeClass = Integer.class)
    })
    public CommonResult testRedis(@RequestParam(defaultValue = "key") String key,@RequestParam(defaultValue = "value") String value,@RequestParam(defaultValue = "-1") int time){
        redisUtil.stringSet(key,value,time);
        return CommonResult.success();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation("Register user")
    public CommonResult register(){
        return CommonResult.success();
    }
}
