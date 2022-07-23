package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No_2580 {

    static StringTokenizer st;
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fillBoard(0,0);

    }

    public static void fillBoard(int x, int y) {

        if (y == 9) {
            fillBoard(x+1, 0);
            return;
        }

        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkNum(x,y,i)) {
                    board[x][y] = i;
                    fillBoard(x, y+1);
                }
            }
            board[x][y] = 0;
            return;
        }
        fillBoard(x, y+1);
    }

    public static boolean checkNum(int x, int y, int k) {
        for (int i = 0; i < 9; i++) { // 가로세로 중복검사
            if (board[x][i] == k || board[i][y] == k) {
                return false;
            }
        }
        int xBox = (x/3) * 3;
        int yBox = (y/3) * 3;
        for (int i = xBox; i < xBox + 3; i++) {
            for (int j = yBox; j < yBox + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
