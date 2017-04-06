package com.xuan.gsonapt.testapplication;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by chenxiaoxuan1 on 17/4/1.
 */

public class LeetCode37 {

    @Test
    public void test() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], '.');
        }
        board[0][0] = '5';
        board[0][1] = '3';
        board[0][4] = '7';
        board[1][0] = '6';
        board[1][3] = '1';
        board[1][4] = '9';
        board[1][5] = '5';
        board[2][1] = '9';
        board[2][2] = '8';
        board[2][7] = '6';
        board[3][0] = '8';
        board[3][4] = '6';
        board[3][8] = '3';
        board[4][0] = '4';
        board[4][3] = '8';
        board[4][5] = '3';
        board[4][8] = '1';
        board[5][0] = '7';
        board[5][4] = '2';
        board[5][8] = '6';
        board[6][1] = '6';
        board[6][6] = '2';
        board[6][7] = '8';
        board[7][3] = '4';
        board[7][4] = '1';
        board[7][5] = '9';
        board[7][8] = '5';
        board[8][4] = '8';
        board[8][7] = '7';
        board[8][8] = '9';
        for (int i = 0; i < 9; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < 9; k++) {
                stringBuilder.append("  " + board[i][k]);
            }
            PrintUtil.print(stringBuilder.toString());
        }
        PrintUtil.print("");
        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < 9; k++) {
                stringBuilder.append("  " + board[i][k]);
            }
            PrintUtil.print(stringBuilder.toString());
        }
    }

    public void solveSudoku(char[][] board) {
        setOne(board, 0, 0);
    }

    public boolean setOne(char[][] board, int i, int j) {
        if (j >= 9) {
            i++;
            j = 0;
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) ('0' + k);
                if (isValid(board, i, j)) {
                    if (setOne(board, i, j + 1)) {
                        return true;
                    }
                }
                board[i][j] = '.';
            }
        } else {
            return setOne(board, i, j + 1);
        }

        return false;
    }

    public boolean isValid(char[][] board, int i, int j) {
        int blocki = i / 3 * 3;
        int blockj = j / 3 * 3;

        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j]) {
                return false;
            }
            if (k != j && board[i][k] == board[i][j]) {
                return false;
            }
            int tempi = k / 3 + blocki;
            int tempj = k % 3 + blockj;
            if ((tempi != i || tempj != j) && board[tempi][tempj] == board[i][j]) {
                return false;
            }

        }

        return true;
    }
}
