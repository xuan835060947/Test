package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/5/11.
 */

public class TensentTest {

    @Test
    public void test() {
        boolean[] lights = new boolean[1001];
        for (int i = 1; i <= 1000; i++) {
            int index = i;
            while (index <= 1000) {
                lights[index] = !lights[index];
                index += i;
            }
        }

        int index = 1;
        for (int i = 1; i <= 1000; i++) {
            if (lights[i]) {
                System.out.println(" 第 "+index+" : " + i);
                index++;
            }
        }
        System.out.println();
        System.out.println("最后一个数31*31 :  " + (31 * 31));
    }
}
