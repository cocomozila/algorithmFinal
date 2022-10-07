package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11054 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] DP = new int[N];
        int[] DP2 = new int[N];
        int max = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i] = 1;
            DP2[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if (arr[i] > arr[j] && DP2[i] < DP2[j] + 1) {
                    DP2[i] = DP2[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP[i]+DP2[i]);
        }
        System.out.println(max-1);
    }
}
