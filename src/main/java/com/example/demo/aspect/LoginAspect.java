package com.example.demo.aspect;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserLoginService;
import com.example.demo.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class LoginAspect {
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 定义切点为controller包下的UserController类里的login()方法
     * execution(* *..*Service.*(..))
     * 1.第一个*表示返回值，*就代表任意返回值
     * 2.第二个*代表包名，*代表任意包名，后边的".."表示前边包名的子包、孙子包等所有的后代包
     * 3.第三个*表示类名，*依然表示类名随意，而上边例子里面的*Service表示任意以Service结尾的类
     * 4.第四个*用于定义方法，*表示任意方法，(..)表示方法的参数也是任意的。
     */
    @Pointcut("execution(* com.example.demo.controller.UserController.login(..))")
    public void pointCut(){}


    /**
     * 前置通知，在前置通知里一般是给变量赋值
     * @param joinPoint
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before method");
    }



    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String username = request.getParameter("username");
        Long userId = userInfoService.getUserByUsername(username).getId();  // 当找不到userId时，会返回null。但在此处找不到username时已经抛出异常，并不会执行到这里
        String userAgent = request.getHeader("User-Agent");
        UserAgent ua = UserAgentUtil.parse(userAgent);
        userLoginService.insertLog(userId, ua.getBrowser().toString(), ua.getPlatform().toString(), IpUtils.getIpAddr(request), ua.getOs().toString());
        return result;
    }


    /**
     * 切点方法完成后执行
     */
    @After("pointCut()")
    public void after(){
        log.info("After method");
    }

    /**
     * 切点方法抛出通知后执行
     * @param e
     */
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowable(Throwable e){
        log.error("After throwable");
    }


    /**
     * 切点方法返回后执行
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "pointCut()")
    public void afterReturning(Object object){
        log.info("After returning");
    }

}

/*
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       Object result;
       try {
           //@Before
           result = method.invoke(target, args);
           //@After
           return result;
       } catch (InvocationTargetException e) {
           Throwable targetException = e.getTargetException();
           //@AfterThrowing
           throw targetException;
       } finally {
           //@AfterReturning
       }
       return result;
    }
 */
