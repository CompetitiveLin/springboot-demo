package com.example.demo.Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchTest {

    public static void main(String[] args){
        int[] array1 = {0, 2, 3, 4, 5, 8, 19, 22};
        System.out.println("Array1： " + Arrays.toString(array1));
        System.out.println(binarySearch(array1, 0, array1.length - 1, 19));
        System.out.println("-----");
        int[] array2 = {2, 3, 3, 3, 3, 3, 5, 7, 8, 9};
        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println("Lower bound of array2: " + lower_bound(array2, 0, array2.length, 3));
        System.out.println("Upper bound of array2: " + upper_bound(array2, 0, array2.length, 3));
    }

    /**
     *
     * @param arrays
     * @param left = 0
     * @param right = arrays.length - 1
     * @param target
     * @return
     */
    public static int binarySearch(int[] arrays, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target > arrays[mid]){
                left = mid + 1;
            } else if(target < arrays[mid]){
                right = mid - 1;
            } else return mid;
        }
        return -1;
    }


    /**
     *
     * @param arrays
     * @param left = 0
     * @param right = arrays.length
     * @param target
     * @return
     */
    public static int lower_bound(int[] arrays, int left, int right, int target){
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target > arrays[mid]){
                left = mid + 1;
            } else right = mid;
        }
        if (left >= arrays.length || arrays[left] != target) {
            return -1;
        }
         return left;
    }


    /**
     *
     * @param arrays
     * @param left = 0
     * @param right = arrays.length
     * @param target
     * @return
     */
    public static int upper_bound(int[] arrays, int left, int right, int target){
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target < arrays[mid]){
                right = mid;
            } else left = mid + 1;
        }
        if (left - 1 < 0 || arrays[left - 1] != target) {
            return -1;
        }
         return left - 1;
    }


}
