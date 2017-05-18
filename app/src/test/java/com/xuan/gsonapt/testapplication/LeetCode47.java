package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/4/6.
 */

public class LeetCode47 {

    @Test
    public void test() {
        int[] arr1 = {1,2,1};
        List<List<Integer>> result  = permuteUnique(arr1);

        for (List<Integer> list : result){
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer i : list){
                stringBuilder.append(" "+i);
            }
            PrintUtil.print(stringBuilder.toString());
        }
    }


    List<List<Integer>> mResult = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        add(new ArrayList<Integer>(nums.length), nums, new boolean[nums.length], 0);
        return mResult;
    }

    private void add(List<Integer> list, int[] nums, boolean[] use, int used) {
        int length = use.length;
        if(used == length){
            mResult.add(list);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!use[i]) {
                if (i != 0 && nums[i] == nums[i - 1] && !use[i - 1]) {

                } else {
                    List<Integer> newList = new ArrayList<>(length);
                    newList.addAll(list);
                    newList.add(nums[i]);
                    use[i] = true;
                    add(newList, nums, use, used + 1);
                    use[i] = false;
                }
            }
        }

    }

    private int getValue() {
        int i = 0;
        try {
            return i;
        } finally {
            i = 1;
            i++;
        }
    }
}
