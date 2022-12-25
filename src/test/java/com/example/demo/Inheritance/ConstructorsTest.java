package com.example.demo.Inheritance;

class A{
    public String name;
    public A(){
        System.out.println("A的无参构造");
    }
    public A(String name){
        System.out.println("A的有参构造");
    }
}


class B extends A{
    public String name;
    public B(){
        super("names"); // 调用父类有参构造函数
        System.out.println("B的无参构造");
    }
    public B(String name){
        System.out.println("B的有参构造");
    }
}


public class ConstructorsTest {
    public static void main(String[] args) {
        B b1 = new B("name");
        System.out.println("==");
        B b2 = new B();
        System.out.println("==");
        A b3 = new B("name");
        System.out.println("==");
        A b4 = new B();
    }
}
