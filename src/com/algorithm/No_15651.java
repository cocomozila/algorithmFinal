package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No_15651 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] node;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        node = new boolean[n];
        arr = new int[m];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) throws IOException {

        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(n, m, depth + 1);
        }
    }
}
