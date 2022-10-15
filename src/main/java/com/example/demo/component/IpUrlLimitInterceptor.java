package com.example.demo.component;

import cn.hutool.json.JSONUtil;
import com.example.demo.response.CommonResult;
import com.example.demo.response.ResultCode;
import com.example.demo.util.IpUtil;
import com.example.demo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @package: com.example.demo.component
 * @className: IpUrlLimitInterceptor
 * @description: ip+url重复请求现在拦截器
 **/
@Slf4j
@Component
public class IpUrlLimitInterceptor implements HandlerInterceptor {


    @Autowired
    private RedisUtil redisUtil;

    private static final String LOCK_IP_URL_KEY = "ip_url_lock:locked:";

    private static final String IP_URL_REQ_TIME = "ip_url_lock:times:";

    /*
    Allowing 5 times max of same request uri within 1 second, otherwise ip get locked for 60 seconds.
     */
    private static final long LIMIT_TIMES = 5;

    private static final int IP_LOCK_TIME = 60;

    private static final int LIMIT_SECOND = 1;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("Interceptor preHandle: requestUri = {}, ip = {}", httpServletRequest.getRequestURI(), IpUtil.getIpAddr(httpServletRequest));
        if (ipIsLock(IpUtil.getIpAddr(httpServletRequest))) {
            log.info("ip = {} is locked", IpUtil.getIpAddr(httpServletRequest));
            returnJson(httpServletResponse, String.valueOf(JSONUtil.parse(CommonResult.failed(ResultCode.LOCK_IP))));
            return false;
        }
        if (!addRequestTime(IpUtil.getIpAddr(httpServletRequest), httpServletRequest.getRequestURI())) {
            returnJson(httpServletResponse, String.valueOf(JSONUtil.parse(CommonResult.failed(ResultCode.LOCK_IP))));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("Interceptor afterCompletion");
    }

    /**
     * @param ip
     * @return java.lang.Boolean
     * @Description: 判断ip是否被禁用
     */
    private Boolean ipIsLock(String ip) {
        if (redisUtil.hasKey(LOCK_IP_URL_KEY + ip)) {
            return true;
        }
        return false;
    }

    /**
     * @param ip
     * @param uri
     * @return java.lang.Boolean
     * @Description: 记录请求次数
     */
    private Boolean addRequestTime(String ip, String uri) {
        String key = IP_URL_REQ_TIME + ip + ":" + uri;
        if (redisUtil.hasKey(key)) {
            long time = redisUtil.stringIncr(key, 1);
            if (time >= LIMIT_TIMES) {
                redisUtil.getLock(LOCK_IP_URL_KEY + ip, ip, IP_LOCK_TIME);
                return false;
            }
        } else {
            redisUtil.getLock(key, (long) 1, LIMIT_SECOND);
        }
        return true;
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            log.error("LoginInterceptor response error ---> {}", e.getMessage(), e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}