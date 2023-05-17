package com.example.demo.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.example.demo.exception.Asserts;
import com.example.demo.mbg.model.UserInfo;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.example.demo.constant.RedisKeyConstant.captcha.CAPTCHA_EMAIL_ADDRESS;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;

    private final RedisUtil redisUtil;

    private final UserInfoService userInfoService;

    @Override
    public void sendEmail(String emailAddress) {
        if(!Validator.isEmail(emailAddress)){
            Asserts.fail("Not a valid email address.");
        }
        UserInfo userInfo = userInfoService.getUserByEmail(emailAddress);
        if(userInfo == null) Asserts.fail("No account connected to this email!");
        SimpleMailMessage message = new SimpleMailMessage();
        String verificationCode = RandomUtil.randomNumbers(4);
        message.setFrom(username);
        message.setTo(emailAddress);
        message.setSubject("Verification Code");
        message.setText("Code: " + verificationCode);
        String key = CAPTCHA_EMAIL_ADDRESS + emailAddress;
        if (redisUtil.hasKey(key)) {
            Asserts.fail("Already have CAPTCHA_EMAIL_ADDRESS!");
        }
        try{
            javaMailSender.send(message);
            log.info("Email send to {} successful, code is {}.", emailAddress, verificationCode);
        } catch (Exception e){
            Asserts.fail("Sending mail failed.");
        }
        redisUtil.stringSet(key, verificationCode, 60);
    }
}
