package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/27.
 */

public class LeetCode63 {

    @Test
    public void test() {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Assert.assertEquals(2, uniquePathsWithObstacles(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] num = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            num[0][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (obstacleGrid[i][k] != 1) {
                    if (k - 1 >= 0) {
                        num[i][k] += num[i][k - 1];
                    }
                    if (i - 1 >= 0) {
                        num[i][k] += num[i - 1][k];
                    }
                }
            }
        }
        return num[m - 1][n - 1];
    }
}
