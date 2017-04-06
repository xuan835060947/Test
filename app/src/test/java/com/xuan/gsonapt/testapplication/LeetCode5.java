package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/9.
 */

public class LeetCode5 {

    @Test
    public void test() {
        Problem5 problem5 = new Problem5();
        String s = "cbab";
        print(problem5.getKmpPre(s));
        s = "cbbd";
        print(problem5.getKmpPre(s));
        s = "ababaca";
        print(problem5.getKmpPre(s));

    }

    @Test
    public void testProblem() {
        Assert.assertEquals("a", new Problem5().longestPalindrome("abcdasdfghjkldcba"));
        Assert.assertEquals("bb", new Problem5().longestPalindrome("cbbd"));
        Assert.assertEquals("bbbb", new Problem5().longestPalindrome("bbbb"));
        Assert.assertEquals("a", new Problem5().longestPalindrome("abcd"));
        Assert.assertEquals("abccba", new Problem5().longestPalindrome("abccba"));
        Assert.assertEquals("abcdcba", new Problem5().longestPalindrome("abcdcba"));
        Assert.assertEquals("abcdcba", new Problem5().longestPalindrome("aabcdcbas"));
        Assert.assertEquals("a", new Problem5().longestPalindrome("abcda"));
        Assert.assertEquals("aaabaaa", new Problem5().longestPalindrome("aaabaaaa"));
    }

    @Test
    public void testSolution() {
        String s = "cbbd";
        Assert.assertEquals("a", new Solution5().longestPalindrome("abcdasdfghjkldcba"));
        Assert.assertEquals("bb", new Solution5().longestPalindrome(s));
        Assert.assertEquals("bbbb", new Solution5().longestPalindrome("bbbb"));
        Assert.assertEquals("a", new Solution5().longestPalindrome("abcd"));
        Assert.assertEquals("abccba", new Solution5().longestPalindrome("abccba"));
        Assert.assertEquals("abcdcba", new Solution5().longestPalindrome("abcdcba"));
        Assert.assertEquals("abcdcba", new Solution5().longestPalindrome("aabcdcbas"));
        Assert.assertEquals("a", new Solution5().longestPalindrome("abcda"));
        Assert.assertEquals("aaabaaa", new Solution5().longestPalindrome("aaabaaaa"));
    }

    @Test
    public void testManacher() {
        String s = "cbbd";
        Assert.assertEquals("a", getManacherStr("abcdasdfghjkldcba"));
        Assert.assertEquals("bb", getManacherStr(s));
        Assert.assertEquals("bbbb", getManacherStr("bbbb"));
        Assert.assertEquals("a", getManacherStr("abcd"));
        Assert.assertEquals("abccba", getManacherStr("abccba"));
        Assert.assertEquals("abcdcba", getManacherStr("abcdcba"));
        Assert.assertEquals("abcdcba", getManacherStr("aabcdcbas"));
        Assert.assertEquals("a", getManacherStr("abcda"));
        Assert.assertEquals("aaabaaa", getManacherStr("aaabaaaa"));
    }

    private String getManacherStr(String s) {
        char[] t = new char[s.length() * 2 + 2];
        t[0] = '$';
        t[1] = '#';
        for (int i = 0; i < s.length(); ++i) {
            t[2 * i + 2] = s.charAt(i);
            t[2 * i + 3] = '#';
        }

        int[] p = new int[t.length];

        int maxRight = 0, center = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length; ++i) {
            if (maxRight > i) {//如果在覆盖范围,那么以center为中心,左右肯定是对称的
                p[i] = Math.min(p[2 * center - i], maxRight - i);
            } else {
                p[i] = 1;
            }
            while (i + p[i] < t.length && t[i + p[i]] == t[i - p[i]]) {//普通的计算p[i]的方式(从中心向两边比较)
                p[i] = p[i] + 1;
            }
            if (maxRight < i + p[i]) {// 让maxRight始终在覆盖范围的最右边
                maxRight = i + p[i];
                center = i;
            }
            if (resLen < p[i]) {//更新最大的长度
                resLen = p[i];
                resCenter = i;
            }
        }
        int start = (resCenter - resLen) / 2;
        return s.substring(start, start + resLen - 1);
    }

    private void print(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        PrintUtil.print(stringBuilder.toString());
    }
}

class Problem5 {
    int mMax = 1;
    int mStart = 0;
    char[] sChar;


    public String longestPalindrome(String s) {
        sChar = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            longestPalindromeStep(s.substring(i), i);
            if (mMax > length - i) {
                return s.substring(mStart, mMax);
            }
        }
        return s.substring(mStart, mMax);
    }

    public void longestPalindromeStep(String s, int start) {
        int length = sChar.length;
        int[] prefix = getKmpPre(s);
        int oppoLength = s.length();
        char[] oppoChar = new char[oppoLength];
        for (int i = 0; i < oppoLength; i++) {
            oppoChar[i] = sChar[oppoLength - i - 1];
        }
        int pPoint = 0;
        for (int i = 0; i < length; i++) {
            if (pPoint == oppoLength) {
                return;
            }
            while (pPoint != 0 && (sChar[i] != oppoChar[pPoint])) {
                pPoint = prefix[pPoint - 1];
            }
            if (sChar[i] == oppoChar[pPoint]) {
                if (pPoint > mMax) {
                    //判断是否是回文
                    boolean isPalindrome = true;
                    for (int k = 0; k <= (pPoint + 1) / 2; k++) {
                        if (oppoChar[k] != oppoChar[pPoint - k]) {
                            isPalindrome = false;
                        }
                    }
                    if (isPalindrome) {
                        mMax = pPoint;
                        mStart = start + i - pPoint;
                    }

                }
                pPoint++;
            }
        }
    }

    public int[] getKmpPre(String s) {
        char[] sChar = s.toCharArray();
        int length = sChar.length;

        int[] pre = new int[length];
        int k = 0;
        for (int i = 1; i < length; i++) {
            while (k > 0 && sChar[k] != sChar[i]) {
                k = pre[k - 1];
            }
            if (sChar[k] == sChar[i]) {
                k = k + 1;
            }
            pre[i] = k;

        }
        return pre;
    }


}

class Solution5 {
    private int[] next;

    private void GetNext(String s) {
        int i, j;

        i = 0;
        j = -1;

        next[0] = -1;

        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    private int compare(String pattern, String s) //用KMP算法做求出最长的前缀匹配
    {
        int i, j;

        i = 0;
        j = 0;

        int maxLen = 0;
        while (i < s.length()) {
            if (j == -1 || pattern.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j > maxLen) {
                maxLen = j;
            }
            if (j == pattern.length()) {
                return maxLen;
            }
        }
        return maxLen;
    }

    public String longestPalindrome(String s)  //
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        String reverString = new StringBuilder(s).reverse().toString();  //求得到 输入string 的reverse
        next = new int[s.length() + 1];

        String maxPal = "";
        int maxLen = 0;
        int len;
        for (int i = 0; i < s.length(); i++) //枚举所有后缀
        {
            String suffix = reverString.substring(i);
            if (suffix.length() < maxLen) {
                break;
            }
            GetNext(suffix);
            len = compare(suffix, s);
            if (len > maxLen) {
                maxPal = suffix.substring(0, len);
                maxLen = len;
            }

        }
        return maxPal;

    }
}