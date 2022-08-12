package com.example.demo.InterfaceAndAbstractClass;

public interface Interface2 {

    void test1();

    default void test2(){
        System.out.println("Interface2.test2");
    }


    default void test4(){
        System.out.println("Interface2.test4");
    }
}
