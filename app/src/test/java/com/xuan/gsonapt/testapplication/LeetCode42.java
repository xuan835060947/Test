package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * 接雨水
 * 不是自己完全的想法:核心是:如果右边有 >= 左边的高度的地方,那么肯定能和左边围成一块高为左高的区域
 * 右边同理
 * Created by chenxiaoxuan1 on 17/4/6.
 */

public class LeetCode42 {

    @Test
    public void test(){
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6,trap(arr1));
        int[] arr2 = {0,1,0,1};
        Assert.assertEquals(1,trap(arr2));
        int[] arr3 = {0};
        Assert.assertEquals(0,trap(arr3));
        int[] arr4 = {10,1,2,3};
        Assert.assertEquals(3,trap(arr4));
        int[] arr5 = {2,0,2};
        Assert.assertEquals(2,trap(arr5));
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;

        while (l < r && height[l] <= height[l + 1]) {
            ++l;
        }

        while (r > 0 && height[r] <= height[r - 1]) {
            --r;
        }

        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];
            if (lHeight < rHeight) {
                while (l < r && lHeight >= height[++l]) {
                    result += (lHeight - height[l]);
                }
            } else {
                while (l < r && rHeight >= height[--r]) {
                    result += (rHeight - height[r]);
                }
            }
        }

        return result;
    }
}
