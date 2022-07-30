package com.example.demo;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;

public class TestClass {
    @Test
    public void test1(){
        int a = 3;
        System.out.println(ObjectUtil.isNotNull(a));
    }
}
