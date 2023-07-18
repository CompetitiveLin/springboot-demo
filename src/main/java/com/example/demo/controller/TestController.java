package com.example.demo.controller;

import com.example.demo.response.CommonResult;
import com.example.demo.service.RedisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedissonClient redissonClient;


    @GetMapping("/bean-list")
    public List<String> beanList() {
        return Arrays.asList(applicationContext.getBeanDefinitionNames());
    }

    /**
     * 带有@RequestParam：url?后的参数
     * @param key
     * @param value
     * @param time
     * @return
     */
    @GetMapping(value = "/redis")
    @Operation(description = "test redis", parameters = {
            @Parameter(name = "key", description = "键"),
            @Parameter(name = "value", description = "值"),
            @Parameter(name = "time", description = "时长")})
    public CommonResult testRedis(@RequestParam(defaultValue = "key") String key, @RequestParam(defaultValue = "value") String value, @RequestParam(defaultValue = "-1") Integer time){   // 为防止time为null抛出异常，参数中应该为包装类型
        redisService.set(key,value,time);
        return CommonResult.success();
    }

    @GetMapping(value = "/get-lock")
    public CommonResult<?> testRedissonLock(){
        RLock rLock = redissonClient.getLock("TEST");
        rLock.lock();
        try{
            Thread.sleep(10000);
        } catch (Exception e){

        } finally {
            rLock.unlock();
        }
        return CommonResult.success();
    }
}