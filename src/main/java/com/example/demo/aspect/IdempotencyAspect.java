package com.example.demo.aspect;


import com.example.demo.annotation.Idempotency;
import com.example.demo.exception.CustomException;
import com.example.demo.service.RedisService;
import com.example.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

import static com.example.demo.constant.RedisKeyConstant.idempotency.IDEMPOTENCY_PREFIX;


/**
 * 1、自定义业务防止重复提交切面 在controller层注入，标记key变量获取的方式和变量名称
 * 2、本切面主要是用来识别解析得到的key
 * 3、将获取到的key，根据业务规则去执行相应的处理
 * 4、如果判断重复操作，直接断言出异常
 **/
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class IdempotencyAspect {

    private final RedisService redisService;

    @Before("@annotation(com.example.demo.annotation.Idempotency)")
    public void idempotencyCheck(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String authorization = request.getHeader("Authorization");
        String username = JwtUtil.getUserNameBearerToken(authorization);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        log.info(signature.getName());  // beanList
        log.info(String.valueOf(signature.getDeclaringType())); // class com.example.demo.controller.TestController
        log.info(signature.getDeclaringTypeName()); // com.example.demo.controller.TestController
        log.info(String.valueOf(signature.getModifiers())); // 1
        log.info(signature.toString()); // List com.example.demo.controller.TestController.beanList()
        log.info(signature.toShortString());    // TestController.beanList()
        log.info(signature.toLongString()); // public java.util.List com.example.demo.controller.TestController.beanList()

        Method signatureMethod = signature.getMethod();
        Idempotency limit = signatureMethod.getAnnotation(Idempotency.class);
        int period = limit.period();
        String key = IDEMPOTENCY_PREFIX + username + ":" + signature.getDeclaringTypeName() + "." + signature.getName();
        if (redisService.hasKey(key)) {
            throw new CustomException("您按的太快了！休息一下！");
        } else {
            redisService.set(key, "", period);
        }
    }
}
