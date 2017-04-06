package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/31.
 */

public class LeetCode32 {

    @Test
    public void test() {
        Assert.assertEquals(2, longestValidParentheses("()"));
        Assert.assertEquals(4, longestValidParentheses(")())(())("));
        Assert.assertEquals(10, longestValidParentheses(")()())()(()())())(())()"));
        Assert.assertEquals(2, longestValidParentheses("()(()(()"));
        Assert.assertEquals(4, longestValidParentheses("))))())()()(()"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int length = s.length();
        boolean[] isVal = new boolean[length];
        for (int i = 0; i < length - 1; i++) {
            char c = s.charAt(i);
            if (c == '(' && s.charAt(i + 1) == ')') {
                isVal[i] = true;
                isVal[++i] = true;
                max = 2;
            }
        }
        boolean hasNew = true;
        while (hasNew) {
            hasNew = false;
            for (int i = 0; i < length; i++) {
                if (isVal[i] == true) {
                    int start = i - 1;
                    int end = 0;
                    ++i;
                    while (i < length && isVal[i]) {
                        ++i;
                    }
                    end = i;

                    //水滴蔓延
                    while (start >= 0 && end < length) {
                        if (!isVal[start] && !isVal[end]) {
                            if (s.charAt(start) == '(' && s.charAt(end) == ')') {
                                isVal[start] = true;
                                isVal[end] = true;
                                hasNew = true;
                            } else {
                                break;
                            }
                        } else {
                            while (start >= 0 && isVal[start]) {
                                --start;
                                hasNew = true;
                            }
                            while (end < length && isVal[end]) {
                                ++end;
                                hasNew = true;
                            }
                        }
                    }
                    i = end - 1;
                }
            }
        }

        boolean isLink = false;
        int curMax = 0;
        for (int i = 0; i < length; i++) {
            if (isVal[i]) {
                if (isLink) {
                    ++curMax;
                } else {
                    curMax = 1;
                    isLink = true;
                }
                if(curMax > max){
                    max = curMax;
                }
            }else {
                isLink = false;
            }
        }
        return max;
    }

    /**
     * 失败序列:))))())()()(()
     * 不能较好的处理 ()((()
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;

        int length = s.length();
        int curMax = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ++left;
            } else {
                if (left == 0) {
                    curMax = 0;
                } else {
                    --left;
                    curMax += 2;
                    if (curMax > max) {
                        max = curMax;
                    }
                }
            }
        }

        int rightMax = 0;
        int right = 0;
        curMax = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                ++right;
            } else {
                if (right == 0) {
                    curMax = 0;
                } else {
                    --right;
                    curMax += 2;
                    if (curMax > rightMax) {
                        rightMax = curMax;
                    }
                }
            }
        }

        max = max > rightMax ? rightMax : max;
        return max;
    }


}
