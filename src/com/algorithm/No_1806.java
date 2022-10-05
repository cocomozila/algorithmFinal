package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int j = 0;
        int minLength = 99999999;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (sum >= S) {
                while (sum >= S) {
                    minLength = Math.min(minLength, i - j + 1);
                    sum -= arr[j];
                    j++;
                }
            }
        }
        if (minLength == 99999999) {
            System.out.print(0);
            return;
        }
        System.out.print(minLength);
    }
}
