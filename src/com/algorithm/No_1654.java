package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long left = 0;
        long right = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        right++;

        while (left < right) {
            long sum = 0;
            long mid = (left + right) >> 1;

            for (int i = 0; i < K; i++) {
                sum += arr[i] / mid;
            }
            if (sum < N) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.print(left - 1);
    }
}
