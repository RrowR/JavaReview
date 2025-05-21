package com.rrow.study.leetcode;

/**
 * @author: Rrow
 * @date: 2024/11/24 0:30
 * Description:
 */
public class No88合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        // merge(nums1,m,nums2,n,m);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = 1;
        for(int i = 0 ; i < nums1.length && i < nums2.length ; i++){
            if(nums1[i] == nums2[i]) {
                move(nums1,i+1,m-1);
                nums1[i+1] = nums2[i];
            }

        }
    }

    public static void move(int[] nums,int start,int end){
        for(int i = end; i >= start ; i--){
            nums[end+1] = nums[end];
        }
    }
}
