package com.example.demo.Algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReorderListTest {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public static ListNode reverse(ListNode root){
        if(root == null || root.next == null) return root;
        ListNode newRoot = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newRoot;
    }


    public static ListNode func(ListNode root){
        ListNode slow = root, fast = root, pre = null;
        while(fast.next != null && fast.next.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        root = reverse(root);
        ListNode ans = new ListNode(slow.val), temp = ans;
        while(root != null || slow != null){
            temp.next = new ListNode(root.val);
            temp.next.next = new ListNode(slow.val);
            root = root.next;
            slow = slow.next;
            temp = temp.next.next.next;
        }
        while(root != null){
            temp.next = root;
            root = root.next;
        }
        while(slow != null){
            temp.next = slow;
            slow = slow.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            String[] strings = s.split("\\s+");
            int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
            ListNode root = new ListNode(nums[0]), temp = root;
            for(int i = 1; i < nums.length; i++){
                temp.next = new ListNode(nums[i]);
                temp = temp.next;
            }
            ListNode ans = func(root);
            while(ans != null){
                System.out.println(ans.val);
                ans = ans.next;
            }
        }
    }
}
