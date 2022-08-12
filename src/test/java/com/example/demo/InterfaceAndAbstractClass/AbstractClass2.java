package com.example.demo.InterfaceAndAbstractClass;

import org.junit.Test;

// 由于没有重写父类抽象类所有的抽象方法，因此该子类也为抽象方法
public abstract class AbstractClass2 extends AbstractClass {

    // 重写父类抽象类的普通方法，也可不重写
    @Test
    @Override
    public void test3() {
        System.out.println("AbstractClass2.test3");
        super.test3();
    }
}
