package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/21.
 */

public class LeetCode60 {

    @Test
    public void test() {
        PrintUtil.print(getPermutation(2, 2));
    }

    private boolean[] mUsed;
    private int[] mTimes;

    public String getPermutation(int n, int k) {
        if(n==1){
            return "1";
        }
        mTimes = new int[n + 1];
        mUsed = new boolean[n + 1];
        mTimes[1] = 1;
        for (int i = 2; i < n; i++) {
            mTimes[i] = i * mTimes[i - 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        set(k, n, stringBuilder);
        return stringBuilder.toString();
    }

    public void set(int rest, int index, StringBuilder sb) {
        int time = mTimes[index - 1];
        int i = 1;
        while (rest > time) {
            i++;
            rest -= time;
        }
        add(sb, i);
        if (index == 2) {
            add(sb, 1);
            return;
        } else {
            set(rest, index - 1, sb);
        }
    }

    private void add(StringBuilder sb, int index) {
        for (int i = 1; ; i++) {
            if (!mUsed[i]) {
                if (index == 1) {
                    mUsed[i] = true;
                    sb.append((char)('0' + i));
                    return;
                }
                index--;
            }
        }
    }

}
