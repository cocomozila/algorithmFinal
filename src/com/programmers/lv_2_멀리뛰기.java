package com.programmers;

public class lv_2_멀리뛰기 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static long solution(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        long[] DP = new long[n+1];
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i < DP.length; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
        }
        return DP[n];
    }

}
