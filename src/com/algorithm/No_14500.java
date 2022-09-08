package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14500 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int max = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j+1 < M && i+1 < N) {
                    max = Math.max(max, board[i][j] + board[i][j+1] + board[i+1][j] + board[i+1][j+1]);
                }
                if (j+2 < M) {
                    int max1 = 0;
                    int max2 = 0;
                    int a = board[i][j] + board[i][j+1] + board[i][j+2];
                    if (j+3 < M) {
                        max1 = Math.max(max1, board[i][j+3]);
                    }
                    if (i+1 < N) {
                        int b = board[i][j+1] + board[i+1][j+1];
                        max2 = Math.max(board[i][j] + board[i+1][j+2], board[i+1][j] + board[i][j+2]);
                        max = Math.max(max, max2 + b);
                        max1 = Math.max(max1, Math.max(board[i+1][j], Math.max(board[i+1][j+1], board[i+1][j+2])));
                    }
                    if (i-1 >= 0) {
                        max1 = Math.max(max1, Math.max(board[i-1][j], Math.max(board[i-1][j+1], board[i-1][j+2])));
                    }
                    max = Math.max(max, max1 + a);
                }
                if (i+2 < N) {
                    int max1 = 0;
                    int max2 = 0;
                    int a = board[i][j] + board[i+1][j] + board[i+2][j];
                    if (i+3 < N) {
                        max1 = Math.max(max1, board[i+3][j]);
                    }
                    if (j+1 < M) {
                        int b = board[i+1][j] + board[i+1][j+1];
                        max2 = Math.max(board[i][j] + board[i+2][j+1], board[i][j+1] + board[i+2][j]);
                        max = Math.max(max, max2 + b);
                        max1 = Math.max(max1, Math.max(board[i][j+1], Math.max(board[i+1][j+1], board[i+2][j+1])));
                    }
                    if (j-1 >= 0) {
                        max1 = Math.max(max1, Math.max(board[i][j-1], Math.max(board[i+1][j-1], board[i+2][j-1])));
                    }
                    max = Math.max(max, max1 + a);
                }
            }
        }
        System.out.println(max);

    }
}
