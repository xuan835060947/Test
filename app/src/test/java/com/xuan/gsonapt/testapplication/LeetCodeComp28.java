package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/16.
 */

public class LeetCodeComp28 {

    @Test
    public void test() {
        String[] a1 = {"yzy", "aba", "awefzewaf"};
        PrintUtil.print(splitLoopedString(a1));
    }

    public String splitLoopedString(String[] strs) {

        String[] rev = new String[strs.length];
        StringBuilder result = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        int length = strs.length;
        int iNum = 0;
        for (String str : strs) {
            rev[iNum++] = new StringBuilder(str).reverse().toString();
        }

        for (int k = 0; k < length; k++) {
            stringBuilder.append(strs[k].compareTo(rev[k]) > 0 ? strs[k] : rev[k]);
        }

        int max = 0;
        int sbLength = stringBuilder.length();
        for (int i = 1; i < sbLength; i++) {
            if (stringBuilder.charAt(i) > stringBuilder.charAt(max)) {
                max = i;
            } else if (stringBuilder.charAt(i) == stringBuilder.charAt(max)) {
                for (int n = 0; n < length; n++) {
                    int l = max + n >= sbLength ? max + n - sbLength : max + n;
                    int r = i + n >= sbLength ? i + n - sbLength : i + n;
                    if (stringBuilder.charAt(l) > stringBuilder.charAt(r)) {
                        break;
                    } else if (stringBuilder.charAt(l) < stringBuilder.charAt(r)) {
                        max = i;
                    }
                }
            }
        }

        for (int i = max; i < sbLength; i++) {
            result.append(stringBuilder.charAt(i));
        }
        for (int i = 0; i < max; i++) {
            result.append(stringBuilder.charAt(i));
        }

//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String lhs, String rhs) {
//                return rhs.compareTo(lhs);
//            }
//        });

//        int max = 0;
//        int search = max + 1;
//        boolean isSearch = true;
//        for (int i = search; i < length; i++) {
//            int com = strs[i].compareTo(strs[max]);
//            if (com > 0) {
//                max = i;
//            } else if (com == 0) {
//                for (int n = 0; n < length; n++) {
//                    int l = max + n >= length ? max + n - length : max + n;
//                    int r = i + n >= length ? i + n - length : i + n;
//                    int com2 = strs[l].compareTo(strs[r]);
//                    if (com2 < 0) {
//                        max = i;
//                        break;
//                    }else if (com2 > 0){
//                        break;
//                    }
//                }
//            }
//        }
//
//
//        for (int i=0;i<length;i++) {
//            int l = max + i >= length ? max + i - length : max + i;
//            result.append(strs[l]);
//        }

        return result.toString();
    }

    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return nums[0] + "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : nums) {
            stringBuilder.append('0' + i);
        }
        return null;
    }

    public boolean checkRecord(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        boolean hasA = false;
        boolean isLastL = true;
        int hasL = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'A') {
                if (hasA) {
                    return false;
                }
                hasA = true;
            }
            if (s.charAt(i) == 'L') {
                if (isLastL) {
                    hasL++;
                } else {
                    hasL = 1;
                }
                isLastL = true;
                if (hasL > 2) {
                    return false;
                }
            } else {
                isLastL = false;
            }
        }
        return true;
    }
}
