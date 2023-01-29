package com.example.demo.MultiThreading;


public class SynchronizedLockTest {
    private static int num = 0;

    public static void main(String[] args) {

        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        synchronized (lock){
                            lock.notify();
                            Thread.sleep(1000);
                            System.out.println("Thread1: " + num++);
                            lock.wait();
                        }
                    }
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               try{
                   while(true){
                       synchronized (lock){
                           Thread.sleep(2000);
                           lock.notify();
                           System.out.println("Thread2: " + num++);
                           lock.wait();
                       }
                   }
               }
               catch (InterruptedException e){
                   e.printStackTrace();
               }
            }
        });
        t1.start();
        t2.start();
        System.out.println("3");
    }
}
