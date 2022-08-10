package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][];
        int [][] DP = new int[N][];
        int max = 0;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            arr[i] = new int[i+1];
            DP[i] = new int[i+1];

            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    DP[i][j] = DP[i-1][j] + arr[i][j];
                    continue;
                } else if (j == i) {
                    DP[i][j] = DP[i-1][j-1] + arr[i][j];
                    continue;
                }
                DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + arr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(DP[N-1][i], max);
        }
        System.out.println(max);
    }
}
