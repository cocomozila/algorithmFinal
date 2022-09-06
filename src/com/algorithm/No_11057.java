package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11057 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][10];

        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= 10007;
                }
            }
        }
        System.out.println(arr[N][0] % 10007);
    }
}
