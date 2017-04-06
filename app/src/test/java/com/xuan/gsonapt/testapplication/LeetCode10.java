package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/16.
 */

public class LeetCode10 {

    @Test
    public void test() {
        Assert.assertEquals(false, isMatch("aa", "a"));
        Assert.assertEquals(true, isMatch("aa", "aa"));
        Assert.assertEquals(true, isMatch("aa", "a*"));
        Assert.assertEquals(true, isMatch("aa", ".*"));
        Assert.assertEquals(true, isMatch("ab", ".*"));
        Assert.assertEquals(true, isMatch("aab", "c*a*b"));
        Assert.assertEquals(true, isMatch("ccaaab", "c*a*b"));
        Assert.assertEquals(true, isMatch("ccaaabbb", "c*a.*b.*"));
        Assert.assertEquals(false, isMatch("ab", ".*c"));
        Assert.assertEquals(true, isMatch("abb", "a.b"));
        Assert.assertEquals(true, isMatch("a", "."));
        Assert.assertEquals(false, isMatch("a", "a."));
    }

    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        return isMatch(sChar, 0, pChar, 0);
    }

    private boolean isMatch(char[] s, int sStart, char[] p, int pStart) {
        if (pStart >= p.length) {
            if (sStart >= s.length) {
                return true;
            }
            return false;
        }

        if (sStart >= s.length) {
            while (pStart < p.length) {
                if (pStart + 1 < p.length) {
                    if (p[pStart + 1] != '*') {
                        return false;
                    }
                } else {
                    return false;
                }
                pStart = pStart + 2;
            }

            return true;
        }

        if (pStart + 1 < p.length) {

            if (p[pStart] == '.') {
                if (p[pStart + 1] == '*') {
                    while (sStart < s.length) {
                        if (isMatch(s, sStart, p, pStart + 2)) {
                            return true;
                        }
                        sStart++;
                    }
                    return isMatch(s, sStart, p, pStart + 2);
                } else {
                    return isMatch(s, sStart + 1, p, pStart + 1);
                }

            }

            if (p[pStart + 1] != '*') {
                if (s[sStart] == p[pStart]) {
                    return isMatch(s, sStart + 1, p, pStart + 1);
                } else {
                    return false;
                }
            } else {
                if (isMatch(s, sStart, p, pStart + 2)) {
                    return true;
                }
                while (sStart < s.length) {
                    if (s[sStart] == p[pStart]) {
                        if (isMatch(s, sStart + 1, p, pStart + 2)) {
                            return true;
                        }
                        sStart++;
                    } else {
                        return false;
                    }

                }
                return false;
            }

        } else {
            if (p[pStart] == '.') {
                return isMatch(s, sStart + 1, p, pStart + 1);
            } else {
                if (s[sStart] == p[pStart]) {
                    return isMatch(s, sStart + 1, p, pStart + 1);
                } else {
                    return false;
                }
            }
        }

    }
}
