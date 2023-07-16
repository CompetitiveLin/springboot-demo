package com.example.demo.controller;


import com.example.demo.annotation.ParseToken;
import com.example.demo.response.CommonResult;
import com.example.demo.service.CheckinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/checkin")
@RestController
@RequiredArgsConstructor
public class CheckinController {

    private final CheckinService checkinService;


    /**
     * 签到
     * @param username
     * @return
     */
    @PostMapping("/do")
    public CommonResult<Void> doCheckin(@ParseToken String username){
        checkinService.checkin(username);
        return CommonResult.success();
    }


    /**
     *  指定日期补签
     * @param username
     * @param date be like 20230616
     * @return
     */
    @PostMapping("/late")
    public CommonResult<Void> lateCheckin(@ParseToken String username, String date){
        checkinService.lateCheckin(username, date);
        return CommonResult.success();
    }


    /**
     *  统计月级签到情况
     * @param username
     * @param date be like 202306
     * @return count 表示当月签到数量， list 表示当月签到分布图，由0或1组成的字符串，第0位代表当月第一天签到情况
     */
    @GetMapping("/list-monthly")
    public CommonResult<?> listMonthly(@ParseToken String username, String date){
        int count = checkinService.checkinMonthlyCount(username, date);
        Map<String, String> data = new HashMap<>();
        data.put("count", "" + count);
        data.put("list", checkinService.checkinMonthlyList(username, date));
        return CommonResult.success(data);
    }


    /**
     * 统计连续签到情况
     * @param username
     * @return
     */
    @GetMapping("/count-continuously")
    public CommonResult<?> countContinuously(@ParseToken String username){
        int count = checkinService.checkinContinuouslyCount(username);
        Map<String, String> data = new HashMap<>();
        data.put("count", "" + count);
        return CommonResult.success(data);
    }
}
