package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1987 {

    static int R, C;
    static char [][] board;
    static int cnt = 0;
    static boolean [] check = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        check[board[0][0]-'A'] = true;
        dfs(0,0);
        System.out.println(max+1);
    }

    public static void dfs(int y, int x) {

        if (x < C-1) {
            if (!check[board[y][x + 1]-'A']) {
                check[board[y][x + 1]-'A'] = true;
                cnt++;
                dfs(y, x+1);
                cnt--;
                check[board[y][x + 1]-'A'] = false;
            }
        }
        if (y < R-1) {
            if (!check[board[y + 1][x]-'A']) {
                check[board[y + 1][x]-'A'] = true;
                cnt++;
                dfs(y + 1, x);
                cnt--;
                check[board[y + 1][x]-'A'] = false;
            }
        }
        if (x > 0) {
            if (!check[board[y][x - 1]-'A']) {
                check[board[y][x - 1]-'A'] = true;
                cnt++;
                dfs(y, x - 1);
                cnt--;
                check[board[y][x - 1]-'A'] = false;
            }
        }
        if (y > 0) {
            if (!check[board[y - 1][x]-'A']) {
                check[board[y - 1][x]-'A'] = true;
                cnt++;
                dfs(y - 1, x);
                cnt--;
                check[board[y - 1][x]-'A'] = false;
            }
        }
        max = Math.max(cnt, max);
    }
}
