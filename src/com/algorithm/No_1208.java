package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1208 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int sum = 0;
        int cnt = 0;

        while (left < right) {
            int leftIdx = left;
            int rightIdx = right;

            sum += arr[leftIdx] + arr[rightIdx];

            while (leftIdx < rightIdx) {
                if (sum > K) {
                    sum += arr[--rightIdx];
                }
                else if (sum < K) {
                    sum += arr[++leftIdx];
                }
                else {
                    cnt++;
                    sum = 0;
                    break;
                }
            }

            if (sum > K) {
                right--;
                sum = 0;
            } else {
                left++;
                sum = 0;
            }
        }
        System.out.println(cnt);

    }
}
