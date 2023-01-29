package com.example.demo.MultiThreading;

import java.util.HashMap;
import java.util.UUID;

public class ThreadTest {
        public static void main(String[] args) throws Exception {
            final HashMap<String, String> map = new HashMap<String, String>(2);
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        map.put(UUID.randomUUID().toString(), "");
                    }
                }).start();
            }

        }

}
