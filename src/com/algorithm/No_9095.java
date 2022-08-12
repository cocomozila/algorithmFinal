package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9095 {

    static int total = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            dfs(Integer.parseInt(br.readLine()));
            System.out.println(cnt);
            cnt = 0;
        }
    }

    public static void dfs(int a) {

        if (total == a) {
            cnt++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (total < a) {
                total += i;
                dfs(a);
                total -= i;
            }
        }
    }
}
