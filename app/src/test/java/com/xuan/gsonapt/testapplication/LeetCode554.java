package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/4/26.
 */

public class LeetCode554 {

    @Test
    public void test() {
//        int[][] arr = {{1, 2, 2, 1},
//                {3, 1, 2},
//                {1, 3, 2},
//                {2, 4},
//                {3, 1, 2},
//                {1, 3, 1, 1}};
        int[][] arr = {{1}};
        List<List<Integer>> wall = new ArrayList<>();
        for (int[] a : arr) {
            List<Integer> list = new ArrayList<>();
            for (int i : a) {
                list.add(i);
            }
            wall.add(list);
        }
        Assert.assertEquals(2, leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        int count = 0;
        for (List<Integer> list : wall) {
            count += list.size();
        }
        int lines = wall.size();
        int[] sum = new int[count];
        int index = 0;
        for (List<Integer> list : wall) {
            int end = list.size() - 1;
            for (int i = 0; i < list.size(); i++) {
                if (i == end) {
                    break;
                }
                if (i == 0) {
                    sum[index++] = list.get(0);
                } else {
                    sum[index] = sum[index - 1] + list.get(i);
                    index++;
                }
            }
        }
        Arrays.sort(sum);
        int result = 0;
        int same = 0;
        int cur = -1;
        for (int i : sum) {
            if (i <= 0) {
                continue;
            }
            if (i != cur) {
                cur = i;
                same = 1;
            } else {
                same++;
            }
            if (same > result) {
                result = same;
            }
        }
        return lines - result;
    }
}
