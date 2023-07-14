package com.example.demo.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.annotation.Log;
import com.example.demo.exception.Asserts;
import com.example.demo.response.CommonResult;
import com.example.demo.service.CaptchaService;
import com.example.demo.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CaptchaController", description = "验证码管理")
@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private EmailService emailService;

    //uuid，由前端生成后请求后端，具体是防止redis中的key重复
    @Log
    @Operation(description = "获取验证码")
    @RequestMapping(value = "/get-captcha",  method = RequestMethod.GET)
    public CommonResult getRandomCode(String uuid){
        if (ObjectUtil.isEmpty(uuid)) {
            Asserts.fail("UUID为空");
        }
        return CommonResult.success(captchaService.getCaptcha(uuid));
    }


    @Operation(description = "发送邮件验证码")
    @PostMapping("/send-email-captcha")
    public CommonResult sendEmail(String emailAddress){
        emailService.sendEmail(emailAddress);
        return CommonResult.success();
    }

}
