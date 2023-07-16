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

    @PostMapping("/do")
    public CommonResult<Void> doCheckin(@ParseToken String username){
        checkinService.checkin(username);
        return CommonResult.success();
    }

    @GetMapping("/check")
    public CommonResult<Boolean> checkTodayIsCheckin(@ParseToken String username){
        return CommonResult.success(checkinService.isCheckin(username));
    }


    /**
     *
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
     *
     * @param username
     * @param date be like 202306
     * @return
     */
    @GetMapping("/count-monthly")
    public CommonResult<?> countMonthly(@ParseToken String username, String date){
        int count = checkinService.checkinMonthlyCount(username, date);
        Map<String, String> data = new HashMap<>();
        data.put("count", "" + count);
        return CommonResult.success(data);
    }

    @GetMapping("/count-continuously")
    public CommonResult<?> countContinuously(@ParseToken String username){
        int count = checkinService.checkinContinuouslyCount(username);
        Map<String, String> data = new HashMap<>();
        data.put("count", "" + count);
        return CommonResult.success(data);
    }
}
