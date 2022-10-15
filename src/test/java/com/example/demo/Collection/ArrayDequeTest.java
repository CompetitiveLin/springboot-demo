package com.example.demo.Collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ArrayDequeTest {
    @Test
    public static void main(String[] args) {
        ArrayDeque<String> animals= new ArrayDeque<>();
        /*
         *****Stack*****
         */
        animals.push("Pig");
        System.out.println("返回栈顶元素： " + animals.peek());
        System.out.println("返回栈顶元素并弹出： " + animals.pop());

        /*
         *****Queue*****
         */
        animals.add("Dog");
        animals.offer("Horse");
        System.out.println("返回出队元素： " + animals.peek());
        System.out.println("返回出队元素并弹出： " + animals.poll());
        /*
         *****Common*****
         */
        System.out.println("判断是否包含Dog： " + (animals.contains("Dog") ? "是" : "否"));
        System.out.println("转换成数组输出： " + Arrays.toString(animals.toArray()));
    }
}
