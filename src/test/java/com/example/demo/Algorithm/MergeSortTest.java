package com.example.demo.Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortTest {

    public static class Solution {
        private static final int INSERTION_SORT_THRESHOLD = 7;
        private void merge(int[] nums, int left, int right){
            if (right - left <= INSERTION_SORT_THRESHOLD) {
                insertionSort(nums, left, right);
                return;
            }
            int mid = (left + right) >>> 1;
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            if(nums[mid] <= nums[mid + 1]) return;
            mergeSort(nums, left, mid, right);
        }

        private void insertionSort(int[] nums, int left, int right) {
            for (int i = left + 1; i <= right; i++) {
                int temp = nums[i], j = i;
                while (j > left && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                nums[j] = temp;
            }
        }

        private void mergeSort(int[] nums, int left, int mid, int right){
            int l = left, m = mid + 1, index = 0;
            int[] temp = new int[right - left + 1];
            while(l <= mid && m <= right){
                if(nums[l] <= nums[m]){
                    temp[index++] = nums[l++];
                }else{
                    temp[index++] = nums[m++];
                }
            }
            while(l <= mid) temp[index++] = nums[l++];
            while(m <= right) temp[index++] = nums[m++];
            System.arraycopy(temp, 0, nums, left, right - left + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,7,9,1,3,0,6};
        Solution solution = new Solution();
        solution.merge(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
