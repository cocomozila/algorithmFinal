package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2573 {

    static int N, M;
    static int[][] map;
    static boolean[][] check;
    static int[][] meltDownMap;
    static final int[] moveY = {0, 1, 0, -1};
    static final int[] moveX = {1, 0, -1, 0};
    static int icebergCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        meltDownMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        while (true) {
            check = new boolean[N][M];
            meltDownMap = new int[N][M];
            int icebergNumber = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    DFS(i, j);
                    if (icebergCount > 0) {
                        icebergNumber += 1;
                    }
                    icebergCount = 0;
                }
            }
            if (icebergNumber == 0) {
                System.out.println(0);
                return;
            }

            if (icebergNumber > 1) {
                System.out.println(index);
                return;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    removeIceberg(i, j);
                }
            }
            combineMap();
            index += 1;
        }


    }

    private static void DFS(int y, int x) {
        if (isValid(y, x) && !check[y][x] && !isZero(y, x)) {
            check[y][x] = true;
            icebergCount += 1;
            for (int i = 0; i < 4; i++) {
                DFS(y + moveY[i], x + moveX[i]);
            }
        }
    }

    private static void combineMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= Math.abs(meltDownMap[i][j])) {
                    map[i][j] = 0;
                } else {
                    map[i][j] -= Math.abs(meltDownMap[i][j]);
                }
            }
        }
    }

    private static void removeIceberg(int y, int x) {
        if (isZero(y, x)) {
            return;
        }
        int meltDownCount = 0;
        for (int i = 0; i < 4; i++) {
            int a = y + moveY[i];
            int b = x + moveX[i];
            if (isValid(a, b)) {
                if (isZero(a, b)) {
                    meltDownCount += 1;
                }
            }
        }
        meltDownMap[y][x] -= meltDownCount;
    }

    private static boolean isZero(int y, int x) {
        return map[y][x] == 0;
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
