package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No_15650 {

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
            if (!node[i]) {
                node[i] = true;
                arr[depth] = i + 1;
                if ( depth > 0 && arr[depth-1] > arr[depth]) {
                    node[i] = false;
                    continue;
                }
                dfs(n, m, depth + 1);
                node[i] = false;
            }
        }
    }
}
