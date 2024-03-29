package com.example.demo.aspect;

import com.example.demo.exception.Asserts;
import com.example.demo.service.SysLogService;
import com.example.demo.util.IpUtil;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.example.demo.annotation.Log)")
    public void pointcut() { }

    @Around("pointcut()")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        result = point.proceed();
//        try {
//            // 执行方法
//            result = point.proceed();
//        } catch (Throwable e) {
//            Asserts.fail(e.getMessage());
//        }
        long time = System.currentTimeMillis() - beginTime;
        saveLog(point, time);
        return result;
    }

    /**
     * 不能用于封装参数后的方法，例如login方法中的参数是LoginDto，求参数名称步骤中将会得到的是参数的地址。
     * @param joinPoint
     * @param time
     */
	private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        // 获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        StringBuffer params = new StringBuffer();
        if (args != null && paramNames != null) {
            for (int i = 0; i < args.length; i++) {
                params.append(paramNames[i]).append(": ").append(args[i]).append(" ");
            }
        }
        sysLogService.insert(className + "." + methodName + "()", time, params.toString(), IpUtil.getIpAddr(request), new Date());
    }
}