package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int [] arr = new int[N+1];

        int k = 2;
        for (int i = 2; i < N+1; i++) {
            if (i < k) {
                k = 2;
            }
            arr[i] = k;
            k += 2;
        }
        System.out.println(arr[N]);
    }
}
