package com.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내려가기
 *
 * N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.
 * 먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다. 그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다.
 * 바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약 조건을 그림으로 나타내어 보면 다음과 같다. *
 * 별표는 현재 위치이고, 그 아랫 줄의 파란 동그라미는 원룡이가 다음 줄로 내려갈 수 있는 위치이며,
 * 빨간 가위표는 원룡이가 내려갈 수 없는 위치가 된다. 숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오.
 * 점수는 원룡이가 위치한 곳의 수의 합이다.
 */

public class No_2096 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] board = new int[n][3];
        int[][][] DP = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        DP[0][0][0] = board[0][0];
        DP[0][0][1] = board[0][0];
        DP[0][1][0] = board[0][1];
        DP[0][1][1] = board[0][1];
        DP[0][2][0] = board[0][2];
        DP[0][2][1] = board[0][2];

        for (int i = 1; i < n; i++) {
            //최대값 DP구하기
            DP[i][0][0] = Math.max(DP[i - 1][0][0], DP[i - 1][1][0]) + board[i][0];
            DP[i][1][0] = Math.max(DP[i - 1][2][0], Math.max(DP[i - 1][0][0], DP[i - 1][1][0])) + board[i][1];
            DP[i][2][0] = Math.max(DP[i - 1][1][0], DP[i - 1][2][0]) + board[i][2];

            //최소값 DP 구하기
            DP[i][0][1] = Math.min(DP[i - 1][0][1], DP[i - 1][1][1]) + board[i][0];
            DP[i][1][1] = Math.min(DP[i - 1][2][1], Math.min(DP[i - 1][0][1], DP[i - 1][1][1])) + board[i][1];
            DP[i][2][1] = Math.min(DP[i - 1][1][1], DP[i - 1][2][1]) + board[i][2];
        }

        int max = Math.max(DP[n - 1][2][0], Math.max(DP[n - 1][0][0], DP[n - 1][1][0]));
        int min = Math.min(DP[n - 1][2][1], Math.min(DP[n - 1][0][1], DP[n - 1][1][1]));

        System.out.println(max + " " + min);
    }
}
