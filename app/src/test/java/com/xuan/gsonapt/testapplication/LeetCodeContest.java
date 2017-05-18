package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenxiaoxuan1 on 17/4/23.
 */

public class LeetCodeContest {

    @Test
    public void test() {
//        int[][] arr1={{0,1,1,0},{0,1,1,0},{0,0,0,1}};
//        PrintUtil.print(""+longestLine(arr1));
//
//        int[][] arr2={};
//        PrintUtil.print(""+longestLine(arr2));
//        int[][] arr3={{0,0,0},{0,1,0},{1,1,1}};
//        PrintUtil.print(""+longestLine(arr3));

        PrintUtil.print(nearestPalindromic("121"));
        PrintUtil.print(nearestPalindromic("100"));
        PrintUtil.print(nearestPalindromic("99"));
        PrintUtil.print(nearestPalindromic("299"));
        PrintUtil.print(nearestPalindromic("-99"));
        PrintUtil.print(nearestPalindromic("-299"));
        PrintUtil.print(nearestPalindromic("9"));
        PrintUtil.print(nearestPalindromic("-9"));
        PrintUtil.print(nearestPalindromic("-8"));
        PrintUtil.print(nearestPalindromic("11"));
        PrintUtil.print(nearestPalindromic("88"));
        PrintUtil.print(nearestPalindromic("884"));
        PrintUtil.print(nearestPalindromic("1283"));

    }
//    public String nearestPalindromic(String n) {
//        long l = Long.parseLong(n);
//        boolean isBig = n.charAt(0) == '-';
//        char[] s;
//        char[] chars = n.toCharArray();
//        if (isBig == true) {
//            s = Arrays.copyOfRange(chars, 1, n.length());
//        } else {
//            s = Arrays.copyOfRange(chars, 0, n.length());
//        }
//        int center = (s.length + 1) / 2 - 1;
//        for ()
//    }

    public String nearestPalindromic(String n) {
        boolean isBig = n.charAt(0) == '-';
        char[] chars = n.toCharArray();
        char[] s;
        char[] temp;
        if (isBig == true) {
            s = Arrays.copyOfRange(chars, 1, n.length());
        } else {
            s = Arrays.copyOfRange(chars, 0, n.length());
        }
        temp = Arrays.copyOfRange(s, 0, s.length);
        palind(temp);
        long simple = Long.parseLong(new String(temp));
        int center = (s.length + 1) / 2 - 1;
        long value = Long.parseLong(new String(s));
        long plus = (long) Math.pow(10, center);
        long big = value + plus;
        long small = value - plus;
        big = palind(big);
        small = palind(small);
        int i = 1;
        while (big == value || big < value) {
            big = value + plus * i;
            i++;
            big = palind(big);
        }
        i =1;
        while (small == value || small > value){
            small = value - plus * i;
            i++;
            small = palind(small);
        }


        if (big == value) {
            big = small;
        }
        if (simple == value) {
            simple = big;
        }
        if (small == value) {
            small = big;
        }
        long bs = get(big, small, isBig, value);
        long result = get(bs, simple, isBig, value);
        return isBig ? "-" + String.valueOf(result) : String.valueOf(result);
    }

    private long get(long a, long b, boolean isBig, long value) {
        long va = Math.abs(value - a);
        long vb = Math.abs(value - b);
        long result;
        if (va == vb) {
            if (isBig) {
                result = a > b ? a : b;
            } else {
                result = a > b ? b : a;
            }
        } else {
            result = va < vb ? a : b;
        }
        return result;
    }

    private void palind(char[] temp) {
        int center = (temp.length + 1) / 2 - 1;
        for (int i = 0; i <= center; i++) {
            temp[temp.length - 1 - i] = temp[i];
        }
    }

    private long palind(long a) {
        char[] temp = String.valueOf(a).toCharArray();
        int center = (temp.length + 1) / 2 - 1;
        for (int i = 0; i <= center; i++) {
            temp[temp.length - 1 - i] = temp[i];
        }
        return Long.parseLong(new String(temp));
    }

    public boolean isEq(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public int longestLine(int[][] M) {
        int row = M.length;
        if (row == 0) {
            return 0;
        }
        int list = M[0].length;
        int[][] right = new int[row + 1][list + 1];
        int[][] down = new int[row + 1][list + 1];
        int[][] rd = new int[row + 1][list + 1];
        int[][] ld = new int[row + 1][list + 1];
        int max = 0;
        for (int i = row - 1; i >= 0; i--) {
            for (int k = list - 1; k >= 0; k--) {
                if (M[i][k] == 1) {
                    down[i][k] = 1 + down[i + 1][k];
                    right[i][k] = 1 + right[i][k + 1];
                    if (k - 1 >= 0) {
                        ld[i][k] = 1 + ld[i + 1][k - 1];
                    } else {
                        ld[i][k] = 1;
                    }
                    rd[i][k] = 1 + rd[i + 1][k + 1];
                    int temp1 = Math.max(down[i][k], right[i][k]);
                    int temp2 = Math.max(rd[i][k], ld[i][k]);
                    max = Math.max(max, Math.max(temp1, temp2));
                } else {
                    down[i][k] = 0;
                    right[i][k] = 0;
                    ld[i][k] = 0;
                    rd[i][k] = 0;
                }
            }
        }
        return max;
    }
}
