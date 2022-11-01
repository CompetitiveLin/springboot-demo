package com.example.demo.Algorithm;

public class BinarySearchTest {

    public static void main(String[] args){
        int[] array1 = {0, 2, 3, 4, 5, 8, 19, 22};
        System.out.println(binarySearch(array1, 0, array1.length - 1, 19));

        int[] array2 = {2, 3, 3, 3, 5, 7, 8, 9};
        System.out.println("Lower bound of array2: " + lower_bound(array2, 0, array1.length, 3));
        System.out.println("Upper bound of array2: " + upper_bound(array2, 0, array1.length, 3));

        System.out.println("When not found, lower bound of array2: " + lower_bound(array2, 0, array1.length, Integer.MAX_VALUE));
        System.out.println("When not found, upper bound of array2: " + upper_bound(array2, 0, array1.length, Integer.MIN_VALUE));
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

         return left;

//        if (left == arrays.length) return -1;
//        return arrays[left] == target ? left : -1;
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

         return left - 1;

//        if (left - 1 < 0) return -1;
//        return arrays[left - 1] == target ? (left - 1) : -1;
    }


}
