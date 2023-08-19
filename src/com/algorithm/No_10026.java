package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 적록색약
 *
 * 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
 * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데,
 * 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
 * 예를 들어, 그림이 아래와 같은 경우에
 *
 * RRRBB
 * GGBBB
 * BBBRR
 * BBRRR
 * RRRRR
 *
 * 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
 * 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
 */

public class No_10026 {

    static String[][] RGBboard;
    static String[][] RG_Bboard;
    static boolean[][] check1;
    static boolean[][] check2;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static final int MOVE_COUNT = 4;
    static int N;
    static String rgb;
    static String rg_b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        RGBboard = new String[N][N];
        RG_Bboard = new String[N][N];
        check1 = new boolean[N][N];
        check2 = new boolean[N][N];
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < N; j++) {
                String rgbArea = readLine.substring(j, j+1);
                RGBboard[i][j] = rgbArea;
                RG_Bboard[i][j] = rgbArea.equals("B") ? "B" : "R";
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rgb = RGBboard[i][j];
                rg_b = RG_Bboard[i][j];
                if (!check1[i][j]) {
                    answer1 += 1;
                }
                if (!check2[i][j]) {
                    answer2 += 1;
                }
                DFS(i, j, check1, rgb, RGBboard);
                DFS(i, j, check2, rg_b, RG_Bboard);
            }
        }

        System.out.print(answer1 + " " + answer2);
    }

    public static void DFS(int y, int x, boolean[][] check, String rgb, String[][] board) {
        if (isValidNumber1(y, x, check, rgb, board)) {
            check[y][x] = true;
            for (int i = 0; i < MOVE_COUNT; i++) {
                DFS(y + moveY[i], x + moveX[i], check, rgb, board);
            }
        }
    }

    private static boolean isValidNumber1(int y, int x, boolean[][] check, String rgb, String[][] board) {
        return x >= 0 && y >= 0 && x < N && y < N && !check[y][x] && isEqualsRGB(y, x, rgb, board);
    }

    private static boolean isEqualsRGB(int y, int x, String rgb, String[][] board) {
        return board[y][x].equals(rgb);
    }

}
