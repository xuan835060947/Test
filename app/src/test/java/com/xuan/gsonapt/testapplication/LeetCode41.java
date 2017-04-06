package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/5.
 */

public class LeetCode41 {

    @Test
    public void test() {
        int[] arr1 = {1, 2, 0};
        int[] arr2 = {3, 4, -1, 1};
        int[] arr3 = {3};
        int[] arr4 = {};
        int[] arr5 = {1, 1};
        int[] arr6 = {2, 1};
        Assert.assertEquals(3, firstMissingPositive(arr1));
        Assert.assertEquals(2, firstMissingPositive(arr2));
        Assert.assertEquals(1, firstMissingPositive(arr3));
        Assert.assertEquals(1, firstMissingPositive(arr4));
        Assert.assertEquals(2, firstMissingPositive(arr5));
        Assert.assertEquals(3, firstMissingPositive(arr6));

    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        if (length == 1) {
            if (nums[0] == 1) {
                return 2;
            }
        }


        for (int i = 0; i < length; ) {
            int acValue = i + 1;
            if (nums[i] != acValue && nums[i] <= length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

//    private void buildHeap(int[] nums) {
//        int start = nums.length / 2;
//        for (int i = start; i >= 0; i--) {
//            minHeap(nums, i);
//        }
//    }
//
//    private void minHeap(int[] nums, int index) {
//        int length = nums.length;
//        int left = index * 2 + 1;
//        int right = index * 2 + 2;
//        if (left >= length) {
//            return;
//        }
//        if (right >= length) {
//            right = left;
//        }
//
//        if (nums[index] > nums[left] || nums[index] > nums[right]) {
//            int minIndex = nums[left] < nums[right] ? left : right;
//            int temp = nums[index];
//            nums[index] = nums[minIndex];
//            nums[minIndex] = temp;
//            minHeap(nums, minIndex);
//        }
//    }
}
