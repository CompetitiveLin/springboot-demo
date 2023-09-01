package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 防止重复提交
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Idempotency {

    /**
     * 时间显示
     * 这个参数，我们可以随便设定，默认单位是 秒
     * 可以根据不同的业务要求去设定
     */
    int period();

}
