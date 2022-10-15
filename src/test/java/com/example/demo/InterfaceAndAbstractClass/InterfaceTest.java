package com.example.demo.InterfaceAndAbstractClass;

import org.junit.Test;


// 接口可实现多继承
public class InterfaceTest implements Interface, Interface2{

    // 重写接口中未实现的方法
    @Test
    @Override
    public void test1() {
        System.out.println("TestInterface.test1");
    }

    @Test
    @Override
    public void test2() {
        System.out.println("TestInterface.test2");
        Interface.super.test2();
        Interface2.super.test2();
    }
}
