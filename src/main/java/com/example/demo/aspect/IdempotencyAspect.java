package com.example.demo.aspect;


import com.example.demo.annotation.Idempotency;
import com.example.demo.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

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

    @Around("@annotation(com.example.demo.annotation.Idempotency)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        log.info(signature.getName());  // onMessage
        log.info(String.valueOf(signature.getDeclaringType())); // class com.example.demo.component.RocketMQToESListener
        log.info(signature.getDeclaringTypeName()); // com.example.demo.component.RocketMQToESListener
        log.info(String.valueOf(signature.getModifiers())); // 1
        log.info(signature.toString()); // void com.example.demo.component.RocketMQToESListener.onMessage(MessageExt)
        log.info(signature.toShortString());    // RocketMQToESListener.onMessage(..)
        log.info(signature.toLongString()); // public void com.example.demo.component.RocketMQToESListener.onMessage(org.apache.rocketmq.common.message.MessageExt)

        String uniqueKey = null;
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof MessageExt) {
                uniqueKey = ((MessageExt) arg).getMsgId();  // 虽然此处用MsgID，但并**不建议**，建议使用业务唯一标识，如订单号。发送消息 `message.setKeys("Order ID")`，消费消息使用 `message.getKeys()`，以保证此处一定有uniqueKey
            }
        }

        Method signatureMethod = signature.getMethod();
        Idempotency limit = signatureMethod.getAnnotation(Idempotency.class);
        int period = limit.period();
        String key = IDEMPOTENCY_PREFIX + uniqueKey.toString();
        if (redisService.hasKey(key)) {
            return null;
        }
        redisService.set(key, "", period);
        return joinPoint.proceed();
    }
}
