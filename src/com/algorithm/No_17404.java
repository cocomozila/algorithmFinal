package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_17404 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] DP;
        int[][] arr = new int[N][3];
        int min = Integer.MAX_VALUE;
        StringTokenizer st;

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            arr[j][0] = Integer.parseInt(st.nextToken());
            arr[j][1] = Integer.parseInt(st.nextToken());
            arr[j][2] = Integer.parseInt(st.nextToken());
        }


        for (int j = 0; j < 3; j++) {
            DP = new int[N][3];
            DP[0][0] = arr[0][0];
            DP[0][1] = arr[0][1];
            DP[0][2] = arr[0][2];

            for (int i = 0; i < 3; i++) {
                if (i != j) {
                    DP[0][i] = 1000 * 1000 + 1;
                }
            }
            for (int i = 1; i < N; i++) {
                DP[i][0] = Math.min(DP[i - 1][1], DP[i - 1][2]) + arr[i][0];
                DP[i][1] = Math.min(DP[i - 1][0], DP[i - 1][2]) + arr[i][1];
                DP[i][2] = Math.min(DP[i - 1][0], DP[i - 1][1]) + arr[i][2];
            }
            for (int i = 0; i < 3; i++) {
                if (i != j) {
                    min = Math.min(DP[N-1][i], min);
                }
            }
        }
        System.out.println(min);

    }
}
