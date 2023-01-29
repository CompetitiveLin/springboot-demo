package com.example.demo.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<String, String>();

   	 Map<String, String> map = new ConcurrentHashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            MyThread testThread = new MyThread(map, "线程名字：" + i);
            testThread.start();
        }
        //等待所有线程都结束
        while(Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(map.size());
    }
}


class MyThread extends Thread {
    public Map<String, String> map;
    public String name;

    public MyThread(Map<String, String> map, String name) {
        this.map = map;
        this.name = name;
    }
    public void run() {
        for(int i =0;i<10;i++) {
            map.put(i + name, i + name);
        }
    }
}