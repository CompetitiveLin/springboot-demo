package com.example.demo.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.example.demo.utils.RedisUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 获取验证码Base64
     *
     * @param uuid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public String getCaptcha(String uuid) {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(90, 34, 4, 3);
        //设置背景颜色
        captcha.setBackground(Color.WHITE);
        //验证图形验证码的有效性，返回boolean值
        captcha.verify("60");
        //将字符长存入redis，并判断redis中是否存在
        boolean redisCode = redisUtil.stringSet("captcha:" + uuid, captcha.getCode(), 60);
        //如果存入redis中失败，抛出异常
        //这里是自定义异常类，可以自行处理，不影响
        if (!redisCode) {
            Asserts.fail("Redis存入异常");
        }
        //3.这里只返回Base64字符串用来展示
        return captcha.getImageBase64Data();
    }
}
