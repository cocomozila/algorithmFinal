package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1520 {

    static int N, M;
    static StringTokenizer st;
    static int[][] map;
    static int[][] answer;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        answer = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        explore(0,0);
        System.out.println(cnt);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

//    public static void explore(int y, int x) {
//
//        if (y == M-1 && x == N-1) {
//            cnt++;
//            return;
//        }
//
//        for (int j = 0; j < M; j++) {
//            for (int i = 0; i < N; i++) {
//                if (i < N - 1) {
//                    if (map[j][i] > map[j][i + 1]) {
//                        answer[j][i]++;
//                    }
//                }
//                if (j < M - 1) {
//                    if (map[j][i] > map[j + 1][i]) {
//                        answer[j][i]++;
//                    }
//                }
//                if (j > 0) {
//                    if (map[j][i] > map[j - 1][i]) {
//                        answer[j][i]++;
//                    }
//                }
//                if (i > 0) {
//                    if (map[j][i] > map[j][i - 1]) {
//                        answer[j][i]++;
//                    }
//                }
//            }
//        }
//    }

    public static void explore(int y, int x) {

        if (y == M-1 && x == N) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(answer[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if (x == N) {
            explore(y + 1, 0);
        }

        if (x < N - 1) {
            if (map[y][x] > map[y][x + 1]) {
                answer[y][x]++;
            }
        }
        if (y < M - 1) {
            if (map[y][x] > map[y + 1][x]) {
                answer[y][x]++;
            }
        }
        if (y > 0) {
            if (map[y][x] > map[y - 1][x]) {
                answer[y][x]++;
            }
        }
        if (x > 0) {
            if (map[y][x] > map[y][x - 1]) {
                answer[y][x]++;
            }
        }
        explore(y, x + 1);
    }
//    public static void explore(int y, int x) {
//
//        if (y == M-1 && x == N-1) {
//            cnt++;
//            return;
//        }
//
//        if (x < N - 1) {
//            if (map[y][x] > map[y][x + 1]) {
//                explore(y, x + 1);
//            }
//        }
//        if (y < M - 1) {
//            if (map[y][x] > map[y + 1][x]) {
//                explore(y + 1, x);
//            }
//        }
//        if (y > 0) {
//            if (map[y][x] > map[y - 1][x]) {
//                explore(y - 1, x);
//            }
//        }
//        if (x > 0) {
//            if (map[y][x] > map[y][x - 1]) {
//                explore(y, x - 1);
//            }
//        }
//    }
}
