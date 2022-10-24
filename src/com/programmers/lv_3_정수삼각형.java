package com.programmers;

public class lv_3_정수삼각형 {

    public static void main(String[] args) {
        lv_3_정수삼각형 aa = new lv_3_정수삼각형();
        int[][] q = {{7},{3, 8},{8, 1, 0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(aa.solution(q));
    }

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        int max = 0;

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[i+1];
        }
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
