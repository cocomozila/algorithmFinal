package com.programmers;

public class 스킬체크테스트_lv1 {

    public static void main(String[] args) {

        System.out.println(solution(1, 4));
    }

    public static long solution(int a, int b) {
        long answer = 0;
        int high = Math.max(a, b);
        int low = Math.min(a, b);

        for (int i = low; i <= high; i++) {
            answer += i;
        }
        return answer;
    }
}
