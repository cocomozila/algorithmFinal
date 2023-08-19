package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_15686 {

    static int[][] arr;
    static boolean[] check;
    static int[] choiceNumbers;
    static int N;
    static int M;
    static ArrayList<Point> houstList = new ArrayList<>();
    static ArrayList<Point> chickenList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int unit = Integer.parseInt(st.nextToken());
                if (unit == 1) {
                    houstList.add(new Point(i, j));
                } else if (unit == 2) {
                    chickenList.add(new Point(i, j));
                }
            }
        }

        arr = new int[chickenList.size()][houstList.size()];
        check = new boolean[chickenList.size()];
        choiceNumbers = new int[M];

        for (int i = 0; i < chickenList.size(); i++) {
            for (int j = 0; j < houstList.size(); j++) {
                arr[i][j] = Math.abs(houstList.get(j).getY() - chickenList.get(i).getY()) + Math.abs(houstList.get(j).getX() - chickenList.get(i).getX());
            }
        }

        DFS(0, 0);
        System.out.println(min);

    }

    private static void DFS(int depth, int start) {
        if (depth == M) {
            int[] result = new int[houstList.size()];
            Arrays.fill(result, Integer.MAX_VALUE);
            for (int j : choiceNumbers) {
                int sum = 0;
                for (int i = 0; i < houstList.size(); i++) {
                    result[i] = Math.min(arr[j][i], result[i]);
                    sum += result[i];
                }
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (!check[i]) {
                choiceNumbers[depth] = i;
                DFS(depth + 1, i + 1);
                check[i] = false;
            }
        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
