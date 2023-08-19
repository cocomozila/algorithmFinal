package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2239 {

    static int board[][] = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        backTracking(0, 0);
    }

    private static void backTracking(int y, int x) {
        if (x == 9) {
            backTracking(y + 1, 0);
            return;
        }

        if (y == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        if (isZero(board[y][x])) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(y, x, i)) {
                    board[y][x] = i;
                    backTracking(y, x + 1);
                }
            }
            board[y][x] = 0;
            return;
        }
        backTracking(y, x + 1);
    }

    public static boolean isValid(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == num || board[i][x] == num) {
                return false;
            }
        }
        int xBox = (y / 3) * 3;
        int yBox = (x / 3) * 3;
        for (int i = xBox; i < xBox + 3; i++) {
            for (int j = yBox; j < yBox + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isZero(int num) {
        return num == 0;
    }
}
