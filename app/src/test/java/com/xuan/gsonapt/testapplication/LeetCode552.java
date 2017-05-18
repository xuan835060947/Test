package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/24.
 */

public class LeetCode552 {

    @Test
    public void test() {
        Assert.assertEquals(3, new LeetCode552().checkRecord(1));
        Assert.assertEquals(8, new LeetCode552().checkRecord(2));
        Assert.assertEquals(19, new LeetCode552().checkRecord(3));
        Assert.assertEquals(43, new LeetCode552().checkRecord(4));
        Assert.assertEquals(985598218, new LeetCode552().checkRecord(100));
    }

//    public int checkRecord(int n) {
//        if (n == 1) {
//            return 3;
//        }
//        int headL = 1;
//        int headSecondL = 0;
//        int headThreeL = 0;
//        int otherGoodNum = 1;
//        int preGoodNum = 2;
//        for (int i = 2; i <= n; i++) {
//            int otherGoodTemp = otherGoodNum;
//            //+P
//            otherGoodNum = otherGoodNum + headL + headSecondL;
//
//            //+L
//            headSecondL = headL;
//            headL = otherGoodTemp;
//
//            if (i == n - 1) {
//                preGoodNum = otherGoodNum + headL + headSecondL;
//            }
//        }
//        long sum = otherGoodNum + headL + headSecondL + preGoodNum * n;
//        long mod = (long) (Math.pow(10, 9) + 7);
//        return (int) (sum % mod);
//    }

    public int checkRecord(int n) {
        int mod = (int) (Math.pow(10, 9) + 7);
        long[][][] num = new long[n + 1][2][3];
        num[1][0][1] = 1;
        num[1][1][0] = 1;
        num[1][0][0] = 1;

        for (int i = 2; i <= n; i++) {
            num[i][0][0] = (num[i - 1][0][0] + num[i - 1][0][1] + num[i - 1][0][2]) % mod;
            num[i][0][1] = num[i - 1][0][0] % mod;
            num[i][0][2] = num[i - 1][0][1] % mod;
            num[i][1][0] = (num[i - 1][1][0] + num[i - 1][1][1] + num[i - 1][1][2] + num[i - 1][0][0] + num[i - 1][0][1] + num[i - 1][0][2]) % mod;
            num[i][1][1] = num[i - 1][1][0] % mod;
            num[i][1][2] = num[i - 1][1][1] % mod;
        }
        long sum = 0;

        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 3; k++) {
                sum += num[n][i][k];
            }
        }
        return (int) (sum % mod);
    }
//
//    private long mSum = 0;
//
//
//    public int checkRecord(int n) {
//        addOne(0, n, 0, false);
//        long mod = (long) (Math.pow(10, 9) + 7);
//        return (int) (mSum % mod);
//    }
//
//    public void addOne(int index, int n, int headLNum, boolean hasA) {
//        if (index == n) {
//            mSum++;
//        } else {
//            //+A
//            if (hasA) {
//            } else {
//                addOne(index + 1, n, 0, true);
//            }
//
//            // +L
//            if (headLNum == 2) {
//            } else {
//                addOne(index + 1, n, headLNum + 1, hasA);
//            }
//
//            //+P
//            addOne(index + 1, n, 0, hasA);
//        }
//    }

}
