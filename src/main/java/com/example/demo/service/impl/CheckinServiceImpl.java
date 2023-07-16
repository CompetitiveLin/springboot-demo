package com.example.demo.service.impl;

import com.example.demo.exception.CustomException;
import com.example.demo.service.CheckinService;
import com.example.demo.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.List;

import static com.example.demo.constant.RedisKeyConstant.user.USER_CHECKIN;
import static com.example.demo.constant.RedisKeyConstant.user.USER_CHECKIN_RANK;


@Service
@RequiredArgsConstructor
@Slf4j
public class CheckinServiceImpl implements CheckinService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final RedisUtil redisUtil;


    @Override
    public void checkin(String username) {
        LocalDateTime now = LocalDateTime.now();
        String keySuffix = now.format(DateTimeFormatter.ofPattern("yyyyMM:"));
        String key = USER_CHECKIN + keySuffix + username;
        int dayOfMonth = now.getDayOfMonth();
        redisUtil.setBit(key, dayOfMonth -1, true);

        TemporalField temporalField = ChronoField.MILLI_OF_DAY;
        long score =  now.getLong(temporalField);
        String key2 = USER_CHECKIN_RANK + dayOfMonth;
        redisUtil.addIfAbsentZset(key2, username, score);
    }

    @Override
    public boolean isCheckin(String username) {
        LocalDateTime now = LocalDateTime.now();
        String keySuffix = now.format(DateTimeFormatter.ofPattern("yyyyMM:"));
        String key = USER_CHECKIN + keySuffix + username;
        return redisUtil.hasKey(key);
    }


    /**
     *  补签功能，可防止恶意签到，比如一个月签到50天，并且将补签日期的范围限制为2000年1月1日至当天（开区间，即2000年1月1日和当天都不能补签）。
     * @param username
     * @param date is like 20230715
     */
    @Override
    public void lateCheckin(String username, String date) {
        LocalDate targetDate = parseToLocalDateWithDay(date);
        if(!(targetDate.isBefore(LocalDate.now()) && targetDate.isAfter(LocalDate.of(2000, 1, 1)))) throw new CustomException("Date Error");
        String keySuffix = "" + targetDate.getYear() + String.format("%02d", targetDate.getMonthValue()) + ":";
        String key = USER_CHECKIN + keySuffix + username;
        int dayOfMonth = targetDate.getDayOfMonth();
        redisUtil.setBit(key, dayOfMonth -1, true);
    }

    /**
     * 字符串日期转换成LocalDate
     *
     * @param date    20230101  20230201
     * @return
     * @throws ParseException
     */
    @SneakyThrows(ParseException.class)
    private LocalDate parseToLocalDateWithDay(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parse = simpleDateFormat.parse(date);
        Instant instant = parse.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 字符串日期转换LocalDate
     *
     * @param dateWithoutDay    202301  202302
     * @return
     * @throws ParseException
     */
    @SneakyThrows(ParseException.class)
    private LocalDate parseToLocalDateWithOutDay(String dateWithoutDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date parse = simpleDateFormat.parse(dateWithoutDay);
        Instant instant = parse.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 统计每个月的签到总数
     * @param username
     * @param dateWithoutDay is like 202306
     * @return
     */
    @Override
    public int checkinMonthlyCount(String username, String dateWithoutDay) {
        LocalDate dateOfSign = parseToLocalDateWithOutDay(dateWithoutDay);
        String keySuffix = dateOfSign.format(DateTimeFormatter.ofPattern("yyyyMM:"));
        String key = USER_CHECKIN + keySuffix + username;
        Long count = redisTemplate.execute((RedisCallback<Long>) redisConnection -> redisConnection.bitCount(key.getBytes()));
        assert count != null;
        return count.intValue();
    }


    /**
     * 统计到当天为止连续签到的天数
     * @param username
     * @return
     */
    @Override
    public int checkinContinuouslyCount(String username) {
        LocalDateTime now = LocalDateTime.now();
        String keySuffix = now.format(DateTimeFormatter.ofPattern("yyyyMM:"));
        String key = USER_CHECKIN + keySuffix + username;
        int dayOfMonth = now.getDayOfMonth();
        List<Long> result = redisTemplate.opsForValue().bitField(
                key,
                BitFieldSubCommands.create()
                        .get(BitFieldSubCommands.BitFieldType.unsigned(dayOfMonth)).valueAt(0));
        if (result == null || result.isEmpty() || result.get(0) == null || result.get(0) == 0) {
            return 0;
        }
        Long num = result.get(0);
        int count = 0;
        while ((num & 1) != 0) {
            count++;
            num >>>= 1;
        }
        return count;
    }
}
