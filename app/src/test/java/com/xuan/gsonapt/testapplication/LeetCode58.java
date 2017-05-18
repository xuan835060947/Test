package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/20.
 */

public class LeetCode58 {

    @Test
    public void test() {
        lengthOfLastWord(" ");
        lengthOfLastWord("a ");
    }

    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();

        int length = 0;
        boolean hasWord = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                if (hasWord) {
                    break;
                }
            } else {
                hasWord = true;
                length++;
            }
        }
        return length;
    }
}
