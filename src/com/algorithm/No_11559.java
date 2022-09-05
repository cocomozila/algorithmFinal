package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No_11559 {

    static char[][] board = new char[12][6];
    static boolean[][] remove;
    static boolean[][] check;
    static int[] xMove = {1, 0, -1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static char search;
    static boolean isCombo = false;
    static int combo = 0;
    static Queue<Integer> xque = new LinkedList<>();
    static Queue<Integer> yque = new LinkedList<>();
    static Stack<Integer> ystack = new Stack<>();
    static Stack<Integer> xstack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }
        do {
            if (isCombo) {
                combo++;
                remove();
            }
            check = new boolean[12][6];
            remove = new boolean[12][6];
            isCombo = false;
            BFS(0,0);

        } while(isCombo);
        System.out.println(combo);
    }

    public static void BFS(int y, int x) {

        if (x == 6) {
            BFS(y + 1, 0);
        }
        if (y == 12) {
            return;
        }

        if (x < 6 && y < 12) {
            if (!check[y][x] && board[y][x] != '.') {
                search = board[y][x];
                check[y][x] = true;
                ystack.push(y);
                xstack.push(x);

                for (int i = 0; i < 4; i++) {
                    int a = x + xMove[i];
                    int b = y + yMove[i];

                    if (a >= 0 && b >= 0 && a < 6 && b < 12) {
                        if (!check[b][a] && search == board[b][a]) {
                            xque.add(a);
                            yque.add(b);
                        }
                    }
                }
                while (!xque.isEmpty()) {
                    BFS(yque.poll(), xque.poll());
                }
            }
            if (ystack.size() > 3) {
                while (!ystack.isEmpty()) {
                    isCombo = true;
                    int a = xstack.pop();
                    int b = ystack.pop();
                    remove[b][a] = true;
                }
            } else {
                xstack.clear();
                ystack.clear();
            }
            BFS(y, x + 1);
        }

    }

    public static void remove() {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (remove[i][j]) {
                    board[i][j] = '.';
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if (board[j][i] != '.') {
                    queue.add(board[j][i]);
                }
            }
            for (int j = 11; j >= 0; j--) {
                if (!queue.isEmpty()) {
                    board[j][i] = queue.poll();
                    continue;
                }
                board[j][i] = '.';
            }
        }
    }
}

//        for (int i = 0; i < 12; i++) {
//        for (int j = 0; j < 6; j++) {
//        System.out.print(board[i][j]);
//        }
//        System.out.println();
//        }
