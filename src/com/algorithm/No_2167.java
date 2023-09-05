package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2167 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] DP = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[0][0] = arr[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i > 0 && j > 0) {
                    DP[i][j] = (DP[i][j - 1] + DP[i - 1][j] + arr[i][j]) - DP[i - 1][j - 1];
                } else if (j > 0) {
                    DP[i][j] = DP[i][j - 1] + arr[i][j];
                } else if (i > 0) {
                    DP[i][j] = DP[i - 1][j] + arr[i][j];
                }
            }
        }

        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            int result = 0;
            if (y == b && x == a) {
                result = arr[y][x];
            } else if (b > 0 && a > 0) {
                result = DP[y][x] - DP[b - 1][x] - DP[y][a - 1] + DP[b - 1][a - 1];
            } else if (b > 0) {
                result = DP[y][x] - DP[b - 1][x];
            } else if (a > 0) {
                result = DP[y][x] - DP[y][a - 1];
            } else {
                result = DP[y][x];
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());

    }
}
