package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2491 {

    static int[] arr;
    static int[][] DP;
    static int max = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        DP = new int[2][N];
        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());

        DP[0][0] = 1;
        DP[1][0] = 1;

        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.max(cal1(i), cal2(i)));
        }

        System.out.println(max);
    }
    private static int cal1(int i) {
        if (arr[i] >= arr[i -1]) {
            DP[0][i] = DP[0][i -1] + 1;
            return DP[0][i];
        }
        DP[0][i] = 1;
        return DP[0][i];
    }

    private static int cal2(int i) {
        if (arr[i] <= arr[i -1]) {
            DP[1][i] = DP[1][i -1] + 1;
            return DP[1][i];
        }
        DP[1][i] = 1;
        return DP[1][i];
    }
}
