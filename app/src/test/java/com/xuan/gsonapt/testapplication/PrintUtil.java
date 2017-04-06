package com.xuan.gsonapt.testapplication;

/**
 * Created by chenxiaoxuan1 on 17/2/14.
 */

public class PrintUtil {
    public static void print(String str){
        System.out.println(str);
    }

    public static void print(int[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr){
            stringBuilder.append(i + " ");
        }
        System.out.println(stringBuilder);

    }

}
