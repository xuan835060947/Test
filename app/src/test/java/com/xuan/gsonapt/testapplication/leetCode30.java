package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/3/29.
 */

public class leetCode30 {

    @Test
    public void test() {
        String[] words = new String[2];
        words[0] = "foo";
        words[1] = "bar";
//        words[2] = "the";
        List<Integer> list = findSubstring("barfoofoobarthefoobarman", words);
        for (Integer i : list) {
            PrintUtil.print("" + i);
        }

        words = new String[3];
        words[0] = "ba";
        words[1] = "ab";
        words[2] = "ab";
//        words[2] = "the";
        list = findSubstring("abaababbaba", words);
        for (Integer i : list) {
            PrintUtil.print("" + i);
        }

        words = new String[2];
        words[0] = "aa";
        words[1] = "aa";
//        words[2] = "the";
        list = findSubstring("aaaaa", words);
        for (Integer i : list) {
            PrintUtil.print("" + i);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }
        int strLength = s.length();
        HashMap<String, Integer> map = new HashMap<>(words.length);
//        HashMap<String, Integer> wordStartMap = new HashMap<>(words.length);

        for (String str : words) {
            Integer i = map.get(str);
            if (i == null) {
                map.put(str, 1);
            } else {
                map.put(str, i + 1);
            }
        }
        int wordLength = words[0].length();

        HashMap<String, Integer> curMap = new HashMap<>(words.length);

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int end = strLength - wordLength;
            int count = 0;
            curMap.clear();
            for (int k = i; k <= end; k += wordLength) {
                String str = s.substring(k, k + wordLength);
                if (map.containsKey(str)) {

                    int strCount = 1;
                    if (curMap.containsKey(str)) {
                        strCount = curMap.get(str) + 1;
                    }
                    curMap.put(str, strCount);

                    if (strCount > map.get(str)) {
                        int searchStart = 0;
                        searchStart = left;
                        while (true) {
                            String nextStr = s.substring(searchStart, searchStart + wordLength);
                            searchStart += wordLength;
                            if (map.containsKey(nextStr)) {
                                curMap.put(nextStr, curMap.get(nextStr) - 1);
                                if (nextStr.equals(str)) {
                                    break;
                                }
                                count--;
                            }
                        }

                        while (true) {//更新left
                            String nextStr = s.substring(searchStart, searchStart + wordLength);
                            if (map.containsKey(nextStr)) {
                                left = searchStart;
                                break;
                            }
                            searchStart += wordLength;
                        }

                    } else {
                        count++;
                        if (count == words.length) {
                            result.add(left);
                            curMap.clear();
                            count = 0;
                            k = left;
                            left = left + wordLength;
                        }
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = k + wordLength;
                }
            }
        }


        return result;
    }

    public ArrayList<Integer> findSubstring2(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        for (int i = 0; i < L[0].length(); i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for (int j = i; j <= S.length() - L[0].length(); j += L[0].length()) {
                String str = S.substring(j, j + L[0].length());

                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))
                        curMap.put(str, curMap.get(str) + 1);
                    else
                        curMap.put(str, 1);
                    if (curMap.get(str) <= map.get(str))
                        count++;
                    else {
                        while (curMap.get(str) > map.get(str)) {
                            String temp = S.substring(left, left + L[0].length());
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp))
                                    count--;
                            }
                            left += L[0].length();
                        }
                    }
                    if (count == L.length) {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left, left + L[0].length());
                        if (curMap.containsKey(temp))
                            curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        left += L[0].length();
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + L[0].length();
                }
            }
        }
        return res;
    }
}
