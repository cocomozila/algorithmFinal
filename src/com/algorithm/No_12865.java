package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_12865 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] v = new int[N];
        int [] w = new int[N];
        int [][] DP = new int[N+1][K+1];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if (w[i-1] > j) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(v[i-1] + DP[i-1][j - w[i-1]], DP[i-1][j]);
                }
                max = Math.max(DP[i][j], max);
            }
        }
        System.out.println(max);

    }
}
