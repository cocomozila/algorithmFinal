package com.programmers;

import java.util.Arrays;

public class lv_2_최솟값만들기 {

    public static void main(String[] args) {

    }
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int j = B.length-1;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[j];
            j -= 1;
        }
        return answer;
    }
}
