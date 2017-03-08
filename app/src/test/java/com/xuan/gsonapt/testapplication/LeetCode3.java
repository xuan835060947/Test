package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenxiaoxuan1 on 17/3/8.
 */

public class LeetCode3 {

    @Test
    public void test() {
        String s = "abcabcbb";
        Assert.assertEquals(lengthOfLongestSubstring(s), 3);
        s = "bbbbb";
        Assert.assertEquals(lengthOfLongestSubstring(s), 1);
        s = "pwwkew";
        Assert.assertEquals(lengthOfLongestSubstring(s), 3);
        s = "abcabcbb";
        Assert.assertEquals(lengthOfLongestSubstring(s), 3);
        s = "a";
        Assert.assertEquals(lengthOfLongestSubstring(s), 1);
        s = "ab";
        Assert.assertEquals(lengthOfLongestSubstring(s), 2);
        s = "ababababababa";
        Assert.assertEquals(lengthOfLongestSubstring(s), 2);
        s = "tmmzuxt";
        Assert.assertEquals(lengthOfLongestSubstring(s), 5);
        int i = 1>>>1;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int max = 0;
        int start = 0;
        int end = 0;
        final int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map[c] != -1) {
                start = map[c] + 1;
                end = i;
                Arrays.fill(map, -1);
                for (int j = start; j < end; j++) {
                    map[s.charAt(j)] = j;
                }
            } else {
                end = i;
                if ((end - start + 1) >= max) {
                    max = end - start + 1;
                }
            }
            map[c] = i;
        }
        return max;
    }
}
