package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_2473 {

    static long saveLeft;
    static long saveMiddle;
    static long saveRight;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long min = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            int left = i;
            int middle = i + 1;
            int right = N - 1;
            while (middle < right) {
                long sum = arr[left] + arr[middle] + arr[right];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    saveNumbers(arr[left], arr[middle], arr[right]);
                }
                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    middle += 1;
                }
            }
        }
        System.out.println(saveLeft + " " + saveMiddle + " " + saveRight);
    }

    private static void saveNumbers(long left, long middle, long right) {
        saveLeft = left;
        saveMiddle = middle;
        saveRight = right;
    }
}
