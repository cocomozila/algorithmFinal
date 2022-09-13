package com.programmers;

import java.util.Stack;
import java.util.TreeSet;

public class 스킬체크테스트_lv3_1 {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        String[] ss = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(8, 2, ss));
    }

    public static String solution(int n, int k, String[] cmd) {

        int pointer = k;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (int i = 0; i < cmd.length; i++) {
            String str = cmd[i];
            switch(str.charAt(0)) {
                case 'U':
                    pointer += Integer.parseInt(String.valueOf(str.charAt(2)));
                    break;
                case 'D':
                    pointer -= Integer.parseInt(String.valueOf(str.charAt(2)));
                    break;
                case 'C':
                    set.remove(k);
                    stack.push(k);
                    if (set.size() == k) {
                        k -= 1;
                    }
                    break;
                case 'Z':
                    set.add(stack.pop());
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append("O");
        }
        while (!stack.isEmpty()) {
            int a = stack.pop();
            System.out.println(a);
            sb.replace(a, a+1, "X");
        }

        return sb.toString();
    }

}
