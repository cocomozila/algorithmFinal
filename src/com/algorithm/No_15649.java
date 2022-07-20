package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No_15649 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n, int m, int depth) throws IOException {

        if (depth == m) {
            for (int i : arr) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!node[i]) {
                node[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                node[i] = false;
            }
        }
    }
}
