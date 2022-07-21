package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9663 {

    static int[] node;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        node = new int[n];
        dfs(n, 0);
        System.out.println(count);

    }

    public static void dfs(int n, int depth) {

        if (depth == n) {
            count++;
            return;
        }


    }
}
