package com.example.demo.service.impl;

import com.example.demo.exception.CustomException;
import com.example.demo.service.CheckinService;
import com.example.demo.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.List;

import static com.example.demo.constant.RedisKeyConstant.user.USER_CHECKIN;
import static com.example.demo.constant.RedisKeyConstant.user.USER_CHECKIN_RANK;


@Service
@RequiredArgsConstructor
@Slf4j
public class CheckinServiceImpl implements CheckinService {

    private final RedisService redisService;


    private String jointKey(LocalDateTime localDateTime, String username){
        return USER_CHECKIN + localDateTime.format(DateTimeFormatter.ofPattern("yyyyMM:")) + username;
    }

    private String jointKeyForRank(){
        return USER_CHECKIN_RANK + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }



    @Override
    public void checkin(String username) {
        LocalDateTime now = LocalDateTime.now();
        String key = jointKey(now, username);
        int dayOfMonth = now.getDayOfMonth();
        redisService.bitSet(key, dayOfMonth -1, true);

        TemporalField temporalField = ChronoField.MILLI_OF_DAY;
        long score =  now.getLong(temporalField);
        String key2 = jointKeyForRank();
        redisService.zAddIfAbsent(key2, username, score);
    }

    /**
     *
     * @param username
     * @param date is like 202306
     * @return
     */

    @Override
    public String checkinMonthlyList(String username, String date) {
        LocalDateTime localDateTime = parseToLocalDateWithOutDay(date).with(TemporalAdjusters.lastDayOfMonth());
        String key = jointKey(localDateTime, username);
        int dayOfMonth = localDateTime.getDayOfMonth();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dayOfMonth; i++){
            if(redisService.bitGet(key, i) == Boolean.TRUE) sb.append("1");
            else sb.append("0");
        }
        return sb.toString();
    }


    /**
     *  补签功能，可防止恶意签到，比如一个月签到50天，并且将补签日期的范围限制为2000年1月1日至当天（开区间，即2000年1月1日和当天都不能补签）。
     * @param username
     * @param date is like 20230715
     */
    @Override
    public void lateCheckin(String username, String date) {
        LocalDateTime targetDate = parseToLocalDateWithDay(date);
        if(!(targetDate.isBefore(LocalDateTime.now()) && targetDate.isAfter(LocalDateTime.of(2000, 1, 1, 0, 0)))) throw new CustomException("Date Error");
        String key = jointKey(targetDate, username);
        int dayOfMonth = targetDate.getDayOfMonth();
        redisService.bitSet(key, dayOfMonth -1, true);
    }

    /**
     * 字符串日期转换成LocalDate
     *
     * @param date    20230101  20230201
     * @return
     * @throws ParseException
     */
    @SneakyThrows(ParseException.class)
    private LocalDateTime parseToLocalDateWithDay(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parse = simpleDateFormat.parse(date);
        Instant instant = parse.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 字符串日期转换LocalDate
     *
     * @param dateWithoutDay    202301  202302
     * @return
     * @throws ParseException
     */
    @SneakyThrows(ParseException.class)
    private LocalDateTime parseToLocalDateWithOutDay(String dateWithoutDay) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date parse = simpleDateFormat.parse(dateWithoutDay);
        Instant instant = parse.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }


    /**
     * 统计每个月的签到总数
     * @param username
     * @param dateWithoutDay is like 202306
     * @return
     */
    @Override
    public int checkinMonthlyCount(String username, String dateWithoutDay) {
        LocalDateTime dateOfSign = parseToLocalDateWithOutDay(dateWithoutDay);
        String key = jointKey(dateOfSign, username);
        Long count = redisService.bitCount(key);
        return count.intValue();
    }


    /**
     * 统计到当天为止连续签到的天数
     * @param username
     * @return
     */
    @Override
    public int checkinContinuouslyCount(String username) {
        int count = 0, innerCount, dayOfMonth;
        LocalDateTime localDateTime = LocalDateTime.now();
        do{
            innerCount = 0;
            String key = jointKey(localDateTime, username);
            dayOfMonth = localDateTime.getDayOfMonth();
            List<Long> result = redisService.bitField(key, dayOfMonth, 0);
            if (result == null || result.isEmpty() || result.get(0) == null || result.get(0) == 0) {
                return count;
            }
            Long num = result.get(0);
            while ((num & 1) != 0) {
                innerCount++;
                count++;
                num >>>= 1;
            }
            localDateTime = localDateTime.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        } while (innerCount == dayOfMonth);
        return count;
    }


    /**
     * 查看当天签到排名，以0开始排序。
     * @param username
     * @return
     */
    @Override
    public long rank(String username) {
        String key = jointKeyForRank();
        Object res = redisService.zRank(key, username);
        if(res == null) throw new CustomException("Checkin first!");
        return (long) res;
    }
}
