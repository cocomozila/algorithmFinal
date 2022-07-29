package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9461 {

    static long [] array = new long[100];
    static long [] base = {1,1,1,2,2};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            dp(Integer.parseInt(br.readLine()));
        }
        System.out.println(sb);
    }

    public static void dp(int n) {

        if (n < 5) {
            for (int i = 0; i < n; i++) {
                array[i] = base[i];
            }
            sb.append(array[n-1]).append("\n");
            return;
        }
        for (int i = 0; i < 5; i++) {
            array[i] = base[i];
        }

        for (int i = 5; i < n; i++) {
            array[i] = array[i-1] + array[i-5];
        }
        sb.append(array[n-1]).append("\n");
    }
}
