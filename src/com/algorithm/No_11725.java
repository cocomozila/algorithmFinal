package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_11725 {

    static ArrayList<Integer> [] list;
    static boolean [] check;
    static int [] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        check = new boolean[N+1];
        answer = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        check[1] = true;
        dfs(list[1], 1);

        for (int i = 2; i < N+1; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(ArrayList<Integer> arr, int num) {

        if (arr.isEmpty()) {
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (!check[arr.get(i)]) {
                answer[arr.get(i)] = num;
                check[arr.get(i)] = true;
                dfs(list[arr.get(i)], arr.get(i));
            }
        }
    }
}
