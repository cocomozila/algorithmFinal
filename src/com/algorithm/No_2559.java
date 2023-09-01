package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N];
        int max = Integer.MIN_VALUE;
        int total = 0;

        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
            if (i < K) {
                total += temp[i];
                if (i == K - 1) {
                    max = Math.max(max, total);
                }
            } else {
                total += temp[i];
                total -= temp[i - K];
                max = Math.max(max, total);
            }
        }
        System.out.println(max);

    }
}
