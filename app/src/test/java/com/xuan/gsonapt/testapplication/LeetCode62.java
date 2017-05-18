package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/27.
 */

public class LeetCode62 {

    @Test
    public void test(){
        Assert.assertEquals(1,uniquePaths(1,1));
        Assert.assertEquals(2,uniquePaths(2,2));
    }

    public int uniquePaths(int m, int n) {
        int[][] num = new int[m][n];
        num[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (k - 1 >= 0) {
                    num[i][k] += num[i][k - 1];
                }
                if (i - 1 >= 0) {
                    num[i][k] += num[i - 1][k];
                }
            }
        }
        return num[m - 1][n - 1];
    }
}
