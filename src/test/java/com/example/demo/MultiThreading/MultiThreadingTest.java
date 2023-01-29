package com.example.demo.MultiThreading;


public class MultiThreadingTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(true){
                        Thread.sleep(1000);
                        System.out.println("Thread 1");
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(true) {
                        Thread.sleep(500);
                        System.out.println("Thread 2");
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
