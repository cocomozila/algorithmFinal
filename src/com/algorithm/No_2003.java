package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr =  new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;
        int left = -1;
        int right = -1;
        while (true) {
            if (sum < M) {
                if (isValidIndex(right, N)) {
                    right += 1;
                    sum += arr[right];
                } else {
                    break;
                }

            } else if (sum > M) {
                if (isValidIndex(left, N)) {
                    left += 1;
                    sum -= arr[left];
                } else {
                    break;
                }

            } else {
                if (isValidIndex(right, N)) {
                    count += 1;
                    right += 1;
                    sum += arr[right];
                } else {
                    count += 1;
                    left += 1;
                    sum -= arr[left];
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isValidIndex (int index, int N) {
        return index < N - 1;
    }
}
