package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_16395 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][];

        for (int i = 0; i < n; i++) {
            board[i] = new int[i+1];
        }

        if (n == 1) {
            board[0][0] = 1;
        } else {
            board[0][0] = 1;
            board[1][0] = 1;
            board[1][1] = 1;
        }

        for (int i = 2; i < n; i++) {
            board[i][0] = 1;
            board[i][i] = 1;
            for (int j = 1; j < i; j++) {
                board[i][j] = board[i - 1][j - 1] + board[i - 1][j];
            }
        }

        System.out.println(board[n - 1][k - 1]);
    }
}
