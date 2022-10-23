package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_17413 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        int n = str.length();
        boolean check = false;

        for (int i = 0; i < n; i++) {
            char a = str.charAt(i);
            if (a == '<' || a == '>') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(a);
                check = !check;
                continue;
            }
            if (check) {
                sb.append(a);
                continue;
            }
            if (a == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                continue;
            }
            stack.push(a);
            if (i == n-1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.print(sb);
    }
}
