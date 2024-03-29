package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11055 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = arr[0];
        int max = DP[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    DP[i] = Math.max(DP[j] + arr[i], DP[i]);
                    max = Math.max(max, DP[i]);
                }
            }
            if (DP[i] == 0) {
                DP[i] = arr[i];
                max = Math.max(max, DP[i]);
            }
        }
        System.out.println(max);

    }
}
