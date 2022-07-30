package com.example.demo.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.common.api.CommonResult;
import com.example.demo.service.ValidateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CaptchaController {
    @Autowired
    private ValidateService validateService;

    //uuid，由前端生成后请求后端，具体是防止redis中的key重复
    @ApiOperation(value = "验证码",notes = "获取验证码")
    @RequestMapping(value = "/getCaptcha",  method = RequestMethod.GET)
    public CommonResult getRandomCode(@RequestParam String uuid){
        if (ObjectUtil.isEmpty(uuid)) {
            return CommonResult.failed("请输入UUID!");
        }
        return CommonResult.success(validateService.getRandomCode(uuid));
    }
}
