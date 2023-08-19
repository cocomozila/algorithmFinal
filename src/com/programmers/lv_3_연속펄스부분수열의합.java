package com.programmers;

public class lv_3_연속펄스부분수열의합 {

    public static void main(String[] args) {
        lv_3_연속펄스부분수열의합 a = new lv_3_연속펄스부분수열의합();
        int[] arr = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(a.solution(arr));
    }

    public long solution(int[] sequence) {

        long max = 0;
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                sum1 += sequence[i];
                sum2 += sequence[i] * -1;
            } else {
                sum1 += sequence[i] * -1;
                sum2 += sequence[i];
            }
            max = Math.max(max, Math.max(sum1, sum2));
            if (sum1 <= 0) {
                sum1 = 0;
            }
            if (sum2 <= 0) {
                sum2 = 0;
            }
        }
        return max;
    }
}
