package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/17.
 */

public class LeetCode11 {

    @Test
    public void test() {
        int[] height = {2, 5, 6,};
        Assert.assertEquals(5, maxArea(height));
        int[] height2 = {1, 1};
        Assert.assertEquals(1, maxArea(height2));
        int[] height3 = {1, 2, 1};
        Assert.assertEquals(2, maxArea(height3));
    }


    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] area = new int[height.length];
        int areaPoint = 0;
        int start = 0;
        int end = height.length - 1;
        while (start != end) {
            area[areaPoint++] = (end - start) * (height[start] < height[end] ? height[start++] : height[end--]);
        }
        int max = 0;
        for (int i : area) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
