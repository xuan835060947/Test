package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/6.
 */

public class LeetCode45 {

    @Test
    public void test() {
        int[] arr1 = {2, 3, 0, 1, 4};
        Assert.assertEquals(2, jump(arr1));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int result = 0;
        int curMax = 0;
        int curReach = 0;
        for (int i = 0; i < length; i++) {

            if (curReach < i) {
                result++;
                curReach = curMax;
            }
            curMax = Math.max(curMax, i + nums[i]);
        }
        return result;
    }

    /**
     * 从后往前
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int[] steps = new int[length];

        for (int i = length - 2; i >= 0; --i) {
            setSteps(nums, i, steps);
        }
        return steps[0];
    }

    private void setSteps(int[] nums, int index, int[] steps) {
        int end = steps.length - 1;
        if (index + nums[index] >= end) {
            steps[index] = 1;
        } else {
            end = index + nums[index];
            int min = Integer.MAX_VALUE;
            for (int i = index + 1; i <= end; i++) {
                if (min > steps[i]) {
                    min = steps[i];
                }
            }
            steps[index] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }
    }
}
