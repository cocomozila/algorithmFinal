package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] DP = new long[N+1];

        if (N == 1) {
            System.out.println(1);
            return;
        }

        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 1;

        for (int i = 3; i < N+1; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        System.out.println(DP[N]);
    }
}
