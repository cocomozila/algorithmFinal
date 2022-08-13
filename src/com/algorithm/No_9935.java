package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9935 {

    static int bombLength, cnt;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        char [] bomb = br.readLine().toCharArray();
        bombLength = bomb.length;
        cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            boolean check = false;
            if (stack.size() >= bomb.length) {
                for (int j = 0; j < bomb.length; j++) {
                    char a = stack.get(stack.size() - bomb.length + j);
                    char b = bomb[j];
                    if (a != b) {
                        check = false;
                        break;
                    }
                    check = true;
                }
                if (check) {
                    for (int k = 0; k < bomb.length; k++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.size() != 0) {
            for (char c : stack) {
                sb.append(c);
            }
        } else {
            System.out.println("FRULA");
        }
        System.out.println(sb);
    }
}
