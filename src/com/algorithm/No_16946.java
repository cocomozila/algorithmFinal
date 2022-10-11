package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No_16946 {

    static int[][] arr;
    static int[] score;
    static int count = 2;
    static int[] xMove = {1, 0, -1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        score = new int[N * M + 2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(String.valueOf(str.charAt(j)));
                arr[i][j] = a;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int sum = 0;
                int total = 0;
                if (arr[i][j] == 1) {

                    for (int k = 0; k < 4; k++) {
                        int ym = i + yMove[k];
                        int xm = j + xMove[k];
                        if (ym >= 0 && ym < N && xm >= 0 && xm < M) {
                            set.add(arr[ym][xm]);
                        }
                    }
                    for (int z : set) {
                        sum += score[z];
                    }
                    total = (sum+1) % 10;
                    set.clear();
                    sb.append(total);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int y, int x) {

        score[count]++;
        arr[y][x] = count;

        for (int i = 0; i < 4; i++) {
            int ym = y + yMove[i];
            int xm = x + xMove[i];
            if (ym >= 0 && ym < N && xm >= 0 && xm < M && arr[ym][xm] == 0) {
                DFS(ym, xm);
            }
        }
    }
}
