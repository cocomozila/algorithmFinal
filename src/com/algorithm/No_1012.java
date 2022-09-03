package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1012 {

    static boolean[][] board;
    static boolean[][] check;
    static int[] xMove = {1, 0, -1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int M;
    static int N;
    static int K;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            board = new boolean[N][M];
            check = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = true;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!board[j][k]) {
                        continue;
                    }
                    DFS(k, j);
                }
            }
            sb.append(cnt).append("\n");
            cnt = 0;
        }
        System.out.print(sb);
    }

    public static void DFS(int x, int y) {

        if (x >= M || y >= N) {
            return;
        }

        if (board[y][x] && !check[y][x]) {
            check[y][x] = true;
            cnt++;
            for (int m = 0; m < 4; m++) {
                int a = x + xMove[m];
                int b = y + yMove[m];
                if (a >= 0 && b >= 0 && a < M && b < N) {
                    if (board[b][a] && !check[b][a]) {
                        DFS(a, b);
                        cnt--;
                    }
                }
            }
        }

    }
}
