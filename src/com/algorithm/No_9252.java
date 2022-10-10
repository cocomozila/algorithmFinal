package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9252 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int arrlen = arr.length;
        int arr2len = arr2.length;
        int[][] DP = new int[arr2len+1][arrlen+1];
        int max = 0;

        for (int i = 1; i < arr2len + 1; i++) {
            for (int j = 1; j < arrlen + 1; j++) {
                if (arr2[i-1] == arr[j-1]) {
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }
        for (int i = 1; i < arrlen + 1; i++) {
            max = Math.max(max, DP[arr2len][i]);
        }
        sb.append(max).append("\n");

        int a = arr2len;
        for (int i = arrlen; i > 0; i--) {
            if (DP[a][i] != DP[a][i-1]) {
                while (DP[a][i] == DP[a-1][i]) {
                    a--;
                    if (DP[a][i] != DP[a-1][i]) {
                        break;
                    }
                }
                a--;
                stack.push(arr[i-1]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
