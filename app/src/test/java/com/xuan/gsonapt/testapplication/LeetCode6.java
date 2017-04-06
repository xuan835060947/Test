package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/15.
 */

public class LeetCode6 {

    @Test
    public void test() {
        String s = "abcdefghi";
        String s2 = "abcdefghij";
        String s3 = "abcdefghijk";
        String s4 = "abcdefghijkl";
        String s5 = "abcdefghijklm";
        String s6 = "abcdefghijklmn";
//        Assert.assertEquals("acdfgibeh", convert(s, 2));
//        Assert.assertEquals("acbdfegih", convert(s2, 2));
        Assert.assertEquals("aeibdfhcg", convert(s, 3));
        Assert.assertEquals("agbfhceid", convert(s, 4));
        Assert.assertEquals("aeibdfhjcg", convert(s2, 3));
        Assert.assertEquals("ABC", convert("ABC", 3));
        Assert.assertEquals("ACBD", convert("ABCD", 2));

    }


    public String convert(String s, int numRows) {
        char[] result = new char[s.length()];
        int length = result.length;
        if (numRows == 1) {
            return s;
        }

//        if (numRows == 2) {
//            int step = 3;
//            int count = result.length / 3 + 1;
//            int resultP = 0;
//            for (int i = 0; i < count; i++) {
//                int real = i * step;
//                if (resultP < length && real < length) {
//                    result[resultP++] = s.charAt(real);
//                }
//                if (resultP < length && real + 2 < length) {
//                    result[resultP++] = s.charAt(real + 2);
//                }
//            }
//            for (int i = 0; i < count; i++) {
//                int real = i * step;
//                if (resultP < length && real + 1 < length) {
//                    result[resultP++] = s.charAt(real + 1);
//                }
//            }
//        } else {
            int step = numRows * 2 - 2;
            int count = result.length / step + 1;
            int resultP = 0;
            for (int i = 0; i < count; i++) {
                int real = i * step;
                if (resultP < length && real < length) {
                    result[resultP++] = s.charAt(real);
                }
            }
            for (int k = 1; k < numRows - 1; k++) {
                for (int i = 0; i < count; i++) {
                    int realStart = i * step + k;
                    int realEnd = i * step + step - k;

                    if (resultP < length && realStart < length) {
                        result[resultP++] = s.charAt(realStart);
                    }
                    if (resultP < length && realEnd < length) {
                        result[resultP++] = s.charAt(realEnd);
                    }
                }
            }

            for (int i = 1; i <= count; i++) {
                int real = i * step - (numRows - 2) - 1;
                if (resultP < length && real < length) {
                    result[resultP++] = s.charAt(real);
                }
            }
//        }


        return String.valueOf(result);
    }
}
