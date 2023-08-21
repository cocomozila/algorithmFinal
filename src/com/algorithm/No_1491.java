package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1491 {

    static int[] moveY = {0, 1, 0, -1};
    static int[] moveX = {1, 0, -1, 0};
    static boolean[][] board;
    static int N;
    static int M;
    static int totalBoardElements;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        totalBoardElements = N * M;

        board = new boolean[N][M];

        int y = 0;
        int x = 0;
        int direction = 0;
        int count = 0;
        board[0][0] = true;

        while (true) {
            if (count == totalBoardElements - 1) {
                System.out.println(x + " " + y);
                return;
            }
            int nextY = y + moveY[direction];
            int nextX = x + moveX[direction];
            if (isValid(nextY, nextX) && !board[nextY][nextX]) {
                board[nextY][nextX] = true;
                y += moveY[direction];
                x += moveX[direction];
                count += 1;
            } else {
                if (direction == 3) {
                    direction = 0;
                } else {
                    direction += 1;
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
