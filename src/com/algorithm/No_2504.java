package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_2504 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int x = 0;
        int y = 1;

        if (str.length() % 2 != 0) {
            System.out.println(0);
            return;
        }

        Stack<Character> stack = new Stack<>();
        Stack<Integer> cover = new Stack<>();

        int combo = 0;
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() > 1) {
                char a = stack.get(stack.size()-2);
                char b = stack.get(stack.size()-1);
                if (a == '(' && b == ')') {
                    if (combo == 0) {
                        combo = 1;
                        stack.pop();
                        stack.pop();
                        x += 2;
                        continue;

                    } else {
                        y *= 2;
                        stack.pop();
                        stack.pop();
                        continue;
                    }
                }
                if (a == '[' && b == ']') {
                    stack.pop();
                    stack.pop();
                    System.out.println(3);
                    continue;
                }
            }
            combo = 0;
        }
    }
}
