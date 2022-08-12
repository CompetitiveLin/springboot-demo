package com.example.demo.InterfaceAndAbstractClass;

public interface Interface {

    void test1();

    // JDK1.8后可以定义default方法体，实现接口的类可以重写(test2)，也可以不重写(test3)
    default void test2(){
        System.out.println("Interface.test2");
    }


    // 也可以不重写(test3)
    default void test3(){
        System.out.println("Interface.test2");
    }
}
