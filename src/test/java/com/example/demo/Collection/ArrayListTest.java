package com.example.demo.Collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites.get(1));  // 访问第二个元素
        sites.set(2, "Wiki"); // 第一个参数为索引位置，第二个为要修改的值
        sites.remove(3); // 删除第四个元素
        Collections.sort(sites);  // 字母排序
        System.out.println(sites.isEmpty());    // 空判断
        System.out.println(sites);
        String[] arr = new String[sites.size()];    // 创建一个新的 String 类型的数组
        sites.toArray(arr); // 将ArrayList对象转换成数组
    }

}
