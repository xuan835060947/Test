package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/27.
 */

public class LeetCode64 {

    @Test
    public void test() {
        int[][] arr = {
                {1, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        Assert.assertEquals(2, minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        int list = grid[0].length;
        int[] sum = new int[list];
        sum[0] = grid[0][0];
        for (int i = 1; i < list; i++) {
            sum[i] = grid[0][i] + sum[i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int k = 0; k < list; k++) {
                int temp1 = sum[k];
                int temp2 = Integer.MAX_VALUE;
                if (k - 1 >= 0) {
                    temp2 = sum[k - 1];
                }
                sum[k] = grid[i][k] + Math.min(temp1, temp2);
            }
        }

        return sum[list - 1];
    }
}
