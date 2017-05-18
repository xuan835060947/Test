package com.xuan.gsonapt.testapplication;

import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/4/14.
 */

public class LeetCode48 {

    @Test
    public void test() {
        int[][] arr2 = {{1, 2}, {3, 4}};
        rotate(arr2);

        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr1);

        int [][] arr3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(arr3);

        int [][] arr4 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        rotate(arr4);
    }

    public void rotate(int[][] matrix) {
        int row = matrix.length;

        int rowHalf = (row + 1) / 2;
        int end = row - 1;
        int k = 0;
        for (int i = 0; i < rowHalf; i++) {
            for (int j = i; j < end - k; j++) {
                swap(matrix, i, j, j, end - i);
                swap(matrix, i, j, end - i, end - j);
                swap(matrix, i, j, end - j, i);
            }
            k++;
        }

        for (int[] arr : matrix) {
            PrintUtil.print(arr);
        }
    }

    private void swap(int[][] matrix, int li, int lj, int ri, int rj) {
        int temp = matrix[li][lj];
        matrix[li][lj] = matrix[ri][rj];
        matrix[ri][rj] = temp;
    }
}
