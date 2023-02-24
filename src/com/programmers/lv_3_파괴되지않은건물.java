package com.programmers;

public class lv_3_파괴되지않은건물 {

    static int[][] DP;

    public static void main(String[] args) {
        lv_3_파괴되지않은건물 a = new lv_3_파괴되지않은건물();
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        int b = a.solution(board, skill);

        System.out.println(b);
    }

    public int solution(int[][] board, int[][] skill) {

        int count = board.length * board[0].length;
        DP = new int[board.length + 1][board[0].length + 1];

        for (int[] i : skill) {
            makeDP(i);
        }

        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[i].length - 1; j++) {
                DP[i][j + 1] += DP[i][j];
            }
        }

        for (int i = 0; i < DP.length - 1; i++) {
            for (int j = 0; j < DP[i].length; j++) {
                DP[i + 1][j] += DP[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += DP[i][j];
                if (board[i][j] <= 0) {
                    count -= 1;
                }
            }
        }

        return count;
    }

    private void makeDP(int[] skill) {
        if (skill[0] == 1) {
            DP[skill[1]][skill[2]] -= skill[5];
            DP[skill[3] + 1][skill[2]] += skill[5];
            DP[skill[1]][skill[4] + 1] += skill[5];
            DP[skill[3] + 1][skill[4] + 1] -= skill[5];
        }
        else {
            DP[skill[1]][skill[2]] += skill[5];
            DP[skill[3] + 1][skill[2]] -= skill[5];
            DP[skill[1]][skill[4] + 1] -= skill[5];
            DP[skill[3] + 1][skill[4] + 1] += skill[5];
        }
    }


}
