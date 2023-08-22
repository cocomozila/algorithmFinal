package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1965 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        int[] DP = new int[N + 1];
        int max = 0;

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                    max = Math.max(DP[i], max);
                }
            }
        }

        System.out.println(max);

    }
}
