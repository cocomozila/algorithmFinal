package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2225 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] DP = new int[K+1][N+1];
        DP[1][N] = 1;

        for (int i = 1; i < K+1; i++) {
            for (int j = N; j > 0; j--) {
                if (j == N) {
                    DP[i][j] = 1;
                }
                DP[i][j-1] = (DP[i][j] + DP[i-1][j-1]) % 1000000000;
            }
        }
        System.out.print(DP[K][0] % 1000000000);
    }
}
