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
        animals.offer("Horse");
        System.out.println("返回队首元素： " + animals.peek());
        System.out.println("返回队首元素并弹出： " + animals.poll());

        /*
         *****Deque*****
         */
        animals.push("Bird");    // 队首
        animals.offer("Dog");    // 队尾
        System.out.println("返回队首元素： " + animals.peek());
        System.out.println("返回队首元素并弹出： " + animals.poll());
        System.out.println("返回队尾元素： " + animals.peekLast());
        System.out.println("返回队尾元素并弹出： " + animals.pollLast());

        /*
         *****Common*****
         */
        System.out.println("判断是否包含Dog： " + (animals.contains("Dog") ? "是" : "否"));
        System.out.println("转换成数组输出： " + Arrays.toString(animals.toArray()));
    }
}
