package com.example.demo.service.impl;

import com.example.demo.service.CheckoutService;
import com.example.demo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

import static com.example.demo.constant.RedisKeyConstant.user.USER_CHECKOUT;
import static com.example.demo.constant.RedisKeyConstant.user.USER_CHECKOUT_RANK;


@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final RedisUtil redisUtil;


    @Override
    public void checkout(String username) {
        LocalDateTime now = LocalDateTime.now();
        String keySuffix = now.format(DateTimeFormatter.ofPattern("yyyyMM:"));
        String key = USER_CHECKOUT + keySuffix + username;
        int dayOfMonth = now.getDayOfMonth();
        redisUtil.setBit(key, dayOfMonth -1, true);

        TemporalField temporalField = ChronoField.MILLI_OF_DAY;
        long score =  now.getLong(temporalField);
        String key2 = USER_CHECKOUT_RANK + dayOfMonth;
        redisUtil.addIfAbsentZset(key2, username, score);
    }

    @Override
    public boolean isCheckout(String username) {
        LocalDateTime now = LocalDateTime.now();
        String keySuffix = now.format(DateTimeFormatter.ofPattern("yyyyMM:"));
        String key = USER_CHECKOUT + keySuffix + username;
        return redisUtil.hasKey(key);
    }
}
