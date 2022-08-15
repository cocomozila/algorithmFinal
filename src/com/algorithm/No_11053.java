package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No_11053 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            DP[i] = 1;

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < N; i++) {
            max = DP[i] > max ? DP[i] : max;
        }
        System.out.println(max);
    }
}

