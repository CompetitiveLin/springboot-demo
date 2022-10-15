package com.example.demo.InterfaceAndAbstractClass;

import org.junit.Test;

// 重写父类的父类所有的抽象方法，因此不为抽象方法
public class AbstractClassTest extends AbstractClass2{

    @Test
    @Override
    public void test1() {
        System.out.println("TestAbstractClass.test1");
    }
}
