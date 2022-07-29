package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_15652 {

    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        answer(n, 0);
        System.out.println(sb);

    }
    public static void answer(int num, int depth) {

        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < num; i++) {
            arr[depth] = i+1;
            if (depth > 0 && arr[depth-1] <= arr[depth]) {
                answer(num, depth + 1);
            }
            else if (depth == 0) {
                answer(num, depth + 1);
            }
        }
    }
}
