package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1388 {

    static int N;
    static int M;
    static boolean[][] check;
    static String[][] board;
    static int count;
    static int totalCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N][M];
        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = readLine.substring(j, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DFS(i, j, board[i][j]);
                if (count > 0) {
                    totalCount += 1;
                    count = 0;
                }
            }
        }

        System.out.println(totalCount);
    }

    public static void DFS(int y, int x, String woodenPlank) {
        if (isValid(y, x) && !check[y][x] && board[y][x].equals(woodenPlank)) {
            check[y][x] = true;
            count += 1;
            if (woodenPlank.equals("-")) {
                DFS(y, x + 1, woodenPlank);
            } else {
                DFS(y + 1, x, woodenPlank);
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
