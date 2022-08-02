package com.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_15655 {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int[] numbers;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        numbers = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) throws IOException {

        if (depth == m) {
            for (int i : numbers) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(arr[i])) {
                numbers[depth] = arr[i];
                dfs(depth + 1);
                numbers[depth] = 0;
            }
        }
    }

    public static boolean check(int a) {
        for (int i = 0; i < m; i++) {
            if (numbers[i] >= a) return false;
        }
        return true;
    }
}
