package com.example.demo.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.annotation.Log;
import com.example.demo.response.CommonResult;
import com.example.demo.service.CaptchaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CaptchaController", description = "验证码管理")
@RestController
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    //uuid，由前端生成后请求后端，具体是防止redis中的key重复
    @Log
    @Operation(description = "获取验证码")
    @RequestMapping(value = "/getCaptcha",  method = RequestMethod.GET)
    public CommonResult getRandomCode(@RequestParam String uuid){
        if (ObjectUtil.isEmpty(uuid)) {
            return CommonResult.failed("请输入UUID!");
        }
        return CommonResult.success(captchaService.getCaptcha(uuid));
    }
}
