package com.programmers;

import java.util.Stack;

public class 짝지어_제거하기 {

    public static void main(String[] args) {

        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));

    }

    public static int solution(String s) {

        char [] a = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);

            if (stack.size() >= 2) {
                if (stack.get(stack.size()-2) == stack.get(stack.size()-1)) {
                    stack.pop();
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
