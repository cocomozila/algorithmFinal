package com.programmers;

public class lv_2_연속된부분수열의합 {

    public static void main(String[] args) {

        lv_2_연속된부분수열의합 a = new lv_2_연속된부분수열의합();
        int[] aa = {1, 2, 3, 4, 5};
        int k = 7;
        a.solution(aa, k);

    }

    public int[] solution(int[] sequence, int k) {

        int left = 0;
        int right = 0;

        int leftM = left;
        int rightM = sequence.length - 1;

        int result = 0;

        while (left <= right) {
            if (result < k) {
                result += sequence[right];
                right += 1;
                continue;
            }
            if (result > k) {
                result -= sequence[left];
                left += 1;
                continue;
            }
            if (result == k) {
                System.out.print("right = " + right);
                System.out.println(" left = " + left);
                System.out.println("result = " + result);
                System.out.println();
                if (rightM - leftM > right - left) {
                    rightM = right;
                    leftM = left;
                }
                if (right < sequence.length) {
                    right += 1;
                    result += sequence[right];
                }
                else {
                    left += 1;
                    result -= sequence[left];
                }
            }

        }
        System.out.println("leftM = " + leftM);
        System.out.println("rightM = " + rightM);

        int[] answer = {};
        return answer;
    }
}
