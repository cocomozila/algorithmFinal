package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 1];
            int[][] DP = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            DP[0][1] = arr[0][1];
            DP[1][1] = arr[1][1];

            for (int m = 2; m <= n; m++) {
                DP[0][m] = Math.max(DP[1][m - 1], DP[1][m - 2]) + arr[0][m];
                DP[1][m] = Math.max(DP[0][m - 1], DP[0][m - 2]) + arr[1][m];
            }

            System.out.println(Math.max(DP[0][n], DP[1][n]));
        }
    }
}
