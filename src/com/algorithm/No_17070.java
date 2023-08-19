package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_17070 {

    static int N;
    static int[][] board;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 1, 0);
        System.out.print(count);


    }

    // (0 가로), (1 세로), (2 대각선)
    public static void DFS(int y, int x, int direction) {
        if (y == N - 1 && x == N - 1) {
            count += 1;
        }

        switch (direction) {
            case 0:
                if (x + 1 < N && isSafeHorizontal(y, x)) {
                    DFS(y, x + 1, 0);
                }
                break;

            case 1:
                if (y + 1 < N && isSafeVertical(y, x)) {
                    DFS(y + 1, x, 1);
                }
                break;

            case 2:
                if (x + 1 < N && isSafeHorizontal(y, x)) {
                    DFS(y, x + 1, 0);
                }
                if (y + 1 < N && isSafeVertical(y, x)) {
                    DFS(y + 1, x, 1);
                }
                break;
        }

        if (y + 1 < N && x + 1 < N && isSafeHorizontal(y, x) && isSafeVertical(y, x) && isSafeDiagonal(y, x)) {
            DFS(y + 1, x + 1, 2);
        }
    }

    private static boolean isSafeHorizontal(int y, int x) {
        return board[y][x + 1] == 0;
    }

    private static boolean isSafeVertical(int y, int x) {
        return board[y + 1][x] == 0;
    }

    private static boolean isSafeDiagonal(int y, int x) {
        return board[y + 1][x + 1] == 0;
    }
}
