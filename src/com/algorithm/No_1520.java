package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1520 {

    static int N, M;
    static StringTokenizer st;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int answer;

        answer = explore(0,0);
        System.out.println(answer);
    }

    public static int explore(int y, int x) {

        if (y == M-1 && x == N-1) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;

        if (x < N - 1) {
            if (map[y][x] > map[y][x + 1]) {
                dp[y][x] += explore(y,x + 1);
            }
        }
        if (y < M - 1) {
            if (map[y][x] > map[y + 1][x]) {
                dp[y][x] += explore(y + 1,x);
            }
        }
        if (y > 0) {
            if (map[y][x] > map[y - 1][x]) {
                dp[y][x] += explore(y - 1,x);
            }
        }
        if (x > 0) {
            if (map[y][x] > map[y][x - 1]) {
                dp[y][x] += explore(y,x - 1);
            }
        }
        return dp[y][x];
    }
}
