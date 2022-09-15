package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9251 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int arrlen = arr.length;
        int arr2len = arr2.length;
        int[][] DP = new int[arr2len+1][arrlen+1];
        int max = 0;

        for (int i = 1; i < arr2len + 1; i++) {
            for (int j = 1; j < arrlen + 1; j++) {
                if (arr2[i-1] == arr[j-1]) {
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }
        for (int i = 1; i < arrlen + 1; i++) {
            max = Math.max(max, DP[arr2len][i]);
        }
        System.out.println(max);

    }
}
