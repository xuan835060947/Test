package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/5.
 */

public class LeetCode43 {

    @Test
    public void test() {
        Assert.assertEquals("2500", multiply("50", "50"));
        Assert.assertEquals("1", multiply("1", "1"));
        Assert.assertEquals("1", multiply("1", "1"));
        Assert.assertEquals(null, multiply("", "1"));
        Assert.assertEquals("56088", multiply("123", "456"));

    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return null;
        }

        int length1 = num1.length();
        int length2 = num2.length();
        int[] numArr1 = new int[length1];
        int[] numArr2 = new int[length2];
        int[] result = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            numArr1[length1 - 1 - i] = num1.charAt(i) - '0';
        }

        for (int i = length2 - 1; i >= 0; i--) {
            numArr2[length2 - 1 - i] = num2.charAt(i) - '0';
        }

        for (int i = 0; i < length2; i++) {
            multiOne(result, numArr1, numArr2[i], i);
        }

        StringBuilder sb = new StringBuilder();
        boolean hasNotZero = false;
        for (int i = result.length - 1; i >= 0; i--) {
            int v = result[i];
            if (!hasNotZero) {
                if (v != 0) {
                    hasNotZero = true;
                    sb.append((char) ('0' + v));
                }
            } else {
                sb.append((char) ('0' + v));
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    /**
     * @param result
     * @param left
     * @param num
     * @param index
     */
    private void multiOne(int[] result, int[] left, int num, int index) {
        for (int i = 0; i < left.length; i++) {
            int multValue = left[i] * num;
            int curBit = index + i;
            int resultNumValue = result[curBit] + multValue % 10;
            int preValue = multValue / 10;
            if (resultNumValue >= 10) {
                result[curBit] = resultNumValue % 10;
                ++preValue;
            } else {
                result[curBit] = resultNumValue;
            }
            result[curBit + 1] += preValue;
            while (result[curBit + 1] >= 10) {
                result[curBit + 2] += 1;
                result[curBit + 1] -=10;
                ++curBit;
            }
        }
    }

}
