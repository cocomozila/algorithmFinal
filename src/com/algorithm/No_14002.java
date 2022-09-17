package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_14002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] DP = new int[N];
        int max = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP[i]);
        }
        sb.append(max).append("\n");

        int a = max;
        for (int i = N-1; i >= 0; i--) {
            if (DP[i] == a && a != 0) {
                a--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
    }
}
