package com.example.demo.Algorithm;

import java.util.Arrays;

public class ReversePairsTest {
    public static class Solution {
        private int ans = 0;
        public int reversePairs(int[] nums) {
            merge(nums, 0, nums.length - 1);
            return ans;
        }

        private void merge(int[] nums, int left, int right){
            if(left < right){
                int mid = left + ((right - left) >> 1);
                merge(nums, left, mid);
                merge(nums, mid + 1, right);
                mergeSort(nums, left, mid, right);
            }
        }

        private void mergeSort(int[] nums, int left, int mid, int right){
            int[] temp = new int[right - left + 1];
            int index = 0, temp_left = left, temp_mid = mid + 1;
            while(temp_left <= mid && temp_mid <= right){
                if(nums[temp_left] <= nums[temp_mid]){
                    temp[index++] = nums[temp_left++];
                }else{
                    ans += mid - temp_left + 1;
                    temp[index++] = nums[temp_mid++];
                }
            }
            while(temp_left <= mid) temp[index++] = nums[temp_left++];
            while(temp_mid <= right) temp[index++] = nums[temp_mid++];
            System.arraycopy(temp, 0, nums, left, right - left + 1);
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3, 5, 8, 1, 2, 7, 4, 9, 6};
        System.out.printf("The number of reverse pairs is %d.\n", solution.reversePairs(nums));
    }
}
