package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiaoxuan1 on 17/4/20.
 */

public class LeetCode51 {

    @Test
    public void test() {
        solveNQueens(5);

        for (List<String> item : mResult) {
            for (String s : item) {
                PrintUtil.print(s);
            }
            PrintUtil.print("");
        }
    }

    private List<List<String>> mResult = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] solve = new boolean[n][n];
        set(0, solve);
        return mResult;
    }

    public void set(int row, boolean[][] solve) {
        if (row == solve.length) {
            addResult(solve);
        } else {
            for (int i = 0; i < solve.length; i++) {
                if (isValiad(row, i, solve)) {
                    solve[row][i] = true;
                    set(row + 1, solve);
                    solve[row][i] = false;
                }
            }
        }
    }

    private boolean isValiad(int row, int list, boolean[][] solve) {
        for (int i = 1; i <= row; i++) {
            if (solve[i - 1][list]) {
                return false;
            }
            if (list - i >= 0 && solve[row - i][list - i]) {
                return false;
            }
            if (list + i < solve.length && solve[row - i][list + i]) {
                return false;
            }
        }
        return true;
    }

    private void addResult(boolean[][] solve) {
        List<String> item = new ArrayList<>(solve.length);
        for (boolean[] row : solve) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : row) {
                if (b) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            item.add(sb.toString());
        }
        mResult.add(item);
    }
}
