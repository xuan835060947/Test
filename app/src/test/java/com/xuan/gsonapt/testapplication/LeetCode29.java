package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/28.
 */

public class LeetCode29 {

    @Test
    public void test() {
        Assert.assertEquals(2, divide(7, 3));
        Assert.assertEquals(5, divide(17, 3));
        Assert.assertEquals(-5, divide(-17, 3));
        Assert.assertEquals(0, divide(0, 3));
        Assert.assertEquals(5, divide(-17, -3));
        Assert.assertEquals(1, divide(1, 1));
        Assert.assertEquals(Integer.MAX_VALUE, divide(Integer.MAX_VALUE, 1));
        Assert.assertEquals(Integer.MAX_VALUE / 3, divide(Integer.MAX_VALUE, 3));
        Assert.assertEquals(Integer.MIN_VALUE, divide(Integer.MIN_VALUE, 1));
        Assert.assertEquals(Integer.MAX_VALUE, divide(Integer.MIN_VALUE, -1));
        Assert.assertEquals(1, divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        Assert.assertEquals(Integer.MIN_VALUE/-3, divide(Integer.MIN_VALUE, -3));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            if(dividend == Integer.MIN_VALUE){
                return 1;
            }

            return 0;
        }

        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                dividend += divisor;
                result += 1;
            } else {
                if(divisor == -1){
                    return Integer.MAX_VALUE;
                }
                dividend -= divisor;
                result += 1;
            }
        }

        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);

        if(absDividend == 0){
            return result;
        }

        while (absDividend >= absDivisor) {
            int shift = 0;
            int mult = 0;
            while (mult >= 0 && mult <= absDividend) {
                mult = absDivisor << shift;
                ++shift;
            }

//            if (shift == 32) {
//                absDividend -= absDivisor << 31;
//                result += 2 << --shift;
//            } else {
            shift -= 2;
            absDividend -= absDivisor << shift;
            if (shift == 0) {
                result += 1;
            } else {
                result += 2 << --shift;
            }
//            }

        }

        if (dividend < 0) {
            result *= -1;
        }

        if (divisor < 0) {
            result *= -1;
        }

        return result;
    }
}
