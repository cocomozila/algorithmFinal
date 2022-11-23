package com.programmers;

import java.util.ArrayList;
import java.util.List;

public class 스킬체크테스트_lv3_221124 {

    static boolean[] check;
    static List<Integer>[] list;
    static int[][] dp;

    public static void main(String[] args) {
        스킬체크테스트_lv3_221124 aa = new 스킬체크테스트_lv3_221124();
        int[][] arr = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        System.out.println(aa.solution(8, arr));
    }

    public int solution(int n, int[][] lighthouse) {
        dp = new int[n + 1][2];
        check = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            int start = lighthouse[i][0];
            int end = lighthouse[i][1];
            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }

    static void dfs(int number) {
        check[number] = true;
        dp[number][0] = 0;
        dp[number][1] = 1;

        for (int num : list[number]) {
            if (!check[num]) {
                dfs(num);
                dp[number][0] += dp[num][1];
                dp[number][1] += Math.min(dp[num][0], dp[num][1]);
            }
        }
    }
}
