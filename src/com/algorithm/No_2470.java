package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_2470 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int saveL = 0;
        int saveR = 0;

        int left = 0;
        int right = N - 1;
        int max = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < max) {
                saveL = arr[left];
                saveR = arr[right];
                max = Math.abs(sum);
            }

            if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }
        sb.append(saveL).append(" ").append(saveR);
        System.out.print(sb);
    }
}
