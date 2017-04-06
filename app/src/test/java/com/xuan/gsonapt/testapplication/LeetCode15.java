package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/3/21.
 */

public class LeetCode15 {

    @Test
    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(1);
        result.add(list);
        list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        list.add(2);
        result.add(list);
//        Assert.assertEquals(result,threeSum(arr));

        int[] arr1 = {0,0,0};
        result = new ArrayList<>();
        list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        result.add(list);
        Assert.assertEquals(result,threeSum(arr1));

        int[] arr2 = {-1,0,1};
        result = new ArrayList<>();
        list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(1);
        result.add(list);
        Assert.assertEquals(result,threeSum(arr2));
    }

    int[] mNewNums;
    int[] mDumpNum;

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int neStart = 0;
        int neEnd = 0;
        int poStart = -1;
        int poEnd = 0;

        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        removeDump(nums);
        for (int i = 0; i < mNewNums.length; i++) {
            if (mNewNums[i] < 0) {
                neEnd = i + 1;
            } else {
                if (poStart == -1) {
                    poStart = i;
                }
                poEnd = i + 1;
            }
        }
        if (poStart == -1) {
            return result;
        } else {
            if (mNewNums[poStart] == 0) {
                if (mDumpNum[poStart] >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(0);
                    list.add(0);
                    list.add(0);
                    result.add(list);
                }
                if (neStart == neEnd) {
                    return result;
                }
            }
        }

        int twoSum = 0;

        //先选择两个负数
        for (int i = neStart; i < neEnd; i++) {
            for (int k = i; k < neEnd; k++) {
                twoSum = 0;
                if (k == i) {
                    if (mDumpNum[i] >= 2) {
                        twoSum += mNewNums[i];
                        twoSum += mNewNums[i];
                    } else {
                        continue;
                    }
                } else {
                    twoSum += mNewNums[i];
                    twoSum += mNewNums[k];
                }
                int search = hasNum(-twoSum, poStart, poEnd);
                if (search >= 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(mNewNums[i]);
                    list.add(mNewNums[k]);
                    list.add(mNewNums[search]);
                    result.add(list);
                }
            }
        }

        //选正数
        for (int i = poStart; i < poEnd; i++) {
            for (int k = i; k < poEnd; k++) {
                twoSum = 0;
                if (k == i) {
                    if (mDumpNum[i] >= 2) {
                        twoSum += mNewNums[i];
                        twoSum += mNewNums[i];
                    } else {
                        continue;
                    }
                } else {
                    twoSum += mNewNums[i];
                    twoSum += mNewNums[k];
                }
                int search = hasNum(-twoSum, neStart, neEnd);
                if (search >= 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(mNewNums[i]);
                    list.add(mNewNums[k]);
                    list.add(mNewNums[search]);
                    result.add(list);
                }
            }
        }


        return result;
    }

    public int hasNum(int num, int start, int end) {
        int i = Arrays.binarySearch(mNewNums, start, end, num);
        if (i >= 0) {
            return i;
        }
        return -1;
    }

    public void removeDump(int[] nums) {
        int index = 0;
        int[] dumpTemp = new int[nums.length];
        int[] newTemp = new int[nums.length];
        Arrays.fill(dumpTemp, 1);

        newTemp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dumpTemp[index]++;
            } else {
                ++index;
                newTemp[index] = nums[i];
            }
        }

        mDumpNum = Arrays.copyOf(dumpTemp, index + 1);
        mNewNums = Arrays.copyOf(newTemp, index + 1);

    }
}
