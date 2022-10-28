package com.programmers;

public class lv_2_숫자의표현 {

    public static void main(String[] args) {
        lv_2_숫자의표현 a = new lv_2_숫자의표현();
        System.out.println(a.solution(9));
    }

    public int solution(int n) {

        if (n < 10) {
            return under10(n);
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n/2+2; i++) {
            for (int j = i; j <= n/2+2; j++) {
                sum += j;
                if (sum == n) {
                    count += 1;
                    sum = 0;
                    break;
                }
                else if (sum > n) {
                    sum = 0;
                    break;
                }
            }
        }
        return count+1;
    }

    public int under10(int n) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    count += 1;
                    sum = 0;
                    break;
                }
                else if (sum > n) {
                    sum = 0;
                    break;
                }
            }
        }
        return count;
    }
}
