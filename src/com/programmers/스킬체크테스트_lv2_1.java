package com.programmers;

public class 스킬체크테스트_lv2_1 {

    public static void main(String[] args) {

        System.out.println(solution(15));
    }

    public static int solution(int n) {

        int answer = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    sum = 0;
                    break;
                }
                if (sum > n) {
                    sum = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
