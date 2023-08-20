package com.programmers;

public class lv_2_연속된부분수열의합 {

    public static void main(String[] args) {
        lv_2_연속된부분수열의합 a = new lv_2_연속된부분수열의합();
        int[] s1 = {2,2,2,2,2,2,2,2,6};
        int[] answer = a.solution(s1, 6);
        System.out.println(answer[0]+" | "+answer[1]);

    }

    public int[] solution(int[] sequence, int k) {

        int min = Integer.MAX_VALUE;
        int saveP1 = 0;
        int saveP2 = 0;

        int p1 = 0;
        int p2 = 0;

        int sum = sequence[0];

        while (p1 < sequence.length) {
            if (sum <= k) {
                if (sum == k && p2 - p1 < min) {
                    saveP1 = p1;
                    saveP2 = p2;
                    min = p2-p1;
                }
                if (p2 < sequence.length - 1) {
                    p2 += 1;
                    sum += sequence[p2];
                } else {
                    sum -= sequence[p1];
                    p1 += 1;
                }
            } else {
                sum -= sequence[p1];
                p1 += 1;
            }
        }

        return new int[]{saveP1, saveP2};
    }
}
