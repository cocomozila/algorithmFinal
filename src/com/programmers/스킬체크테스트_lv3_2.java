package com.programmers;

public class 스킬체크테스트_lv3_2 {

    public static void main(String[] args) {

    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] board2 = board.clone();

        int n = skill.length;
        for (int i = 0; i < n; i++) {
            boolean type = skill[i][0] != 1;
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = 0;
            if (type) {
                degree = skill[i][5];
            } else {
                degree = skill[i][5] * -1;
            }

            for (int j = r1; j <= r2; j++) {
                for (int k = c1; k <= c2; k++) {
                    board2[j][k] += degree;
                }
            }
        }
        for (int i = 0; i < board2.length; i++) {
            for (int j = 0; j < board2[i].length; j++) {
                if (board2[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
