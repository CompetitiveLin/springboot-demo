package com.example.demo.Algorithm;

import java.util.Arrays;

public class KMPTest {

    private static int KMP(int[] master, int[] slave, int pos) {
        int[] next = getNext(slave);
        int i = pos, j = 0;
        while (i < master.length && j < slave.length) {
            if (j == -1 || master[i] == slave[j]) {
                i++;
                j++;
            } else j = next[j];
        }
        if (j == slave.length) return i - j;
        return -1;
    }


    private static int[] getNext(int[] slave) {
        int[] next = new int[slave.length];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < slave.length - 1) {
            if (k == -1 || slave[j] == slave[k]) {
                if (slave[++j] == slave[++k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] master = {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2};
        int[] slave = {1, 1, 1, 1, 1, 2};
        int[] next = getNext(slave);
        System.out.println("Array: " + Arrays.toString(slave) + ".Next arrays is : " + Arrays.toString(next));
        System.out.println("First matching index from 0: " + KMP(master, slave, 0));
        System.out.println("First matching index from 1: " + KMP(master, slave, 1));
        System.out.println("===");
        int[] anotherSlave = {1, 2, 1, 2, 1, 2, 2};
        int[] anotherNext = getNext(anotherSlave);
        System.out.println("Array: " + Arrays.toString(anotherSlave) + ".Next arrays is : " + Arrays.toString(anotherNext));
    }
}
