package com.example.demo.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.example.demo.util.RedisUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 获取验证码Base64.事务的传播默认是用REQUIRED.SUPPORTS和不加Transactional的区别在于
     * 1.前者的方法可以获取和当前事务环境一致的 Connection 或 Session，而后者肯定是新的；
     * 2.前者可以在挂起事务、恢复事务的时侯执行回调方法，而后者做不到。
     * 另外，Redis不支持回滚！
     * @param uuid
     * @return
     */
    @Override
    public String getCaptcha(String uuid){
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
