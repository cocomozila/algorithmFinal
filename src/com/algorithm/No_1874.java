package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] num = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            num[i] = i+1;
        }

        int arrCnt = 0;
        int numCnt = 0;
        try {
            while (true) {
                if (arrCnt == N) {
                    break;
                }
                if (!stack.isEmpty()) {
                    if (arr[arrCnt] == stack.peek()) {
                        stack.pop();
                        arrCnt++;
                        sb.append("-").append("\n");
                        continue;
                    }
                }
                stack.push(num[numCnt]);
                numCnt++;
                sb.append("+").append("\n");
            }
            System.out.println(sb);
        } catch (Exception e) {
            System.out.println("NO");
        }
    }
}
