package com.example.demo.Keywords;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
//    public static volatile int num = 0;
    public static AtomicInteger num = new AtomicInteger(0);

    public static void increase(){
        num.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest volatileTest = new AtomicIntegerTest();
        Thread[] thread = new Thread[20];
        for(int i = 0; i < 20; i++){
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 1000; i++){
                        increase();
                    }
                }
            });
            thread[i].start();
        }

        while(Thread.activeCount() > 2) Thread.yield(); // 有一个守护线程，因此run的话是2，debug的话是1
        System.out.println(num);
    }
}
