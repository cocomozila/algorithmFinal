package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_11724 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N+1];
        int cnt = 0;

        ArrayList<Integer>[] list = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < N+1; i++) {
            if (!check[i]) {
                check[i] = true;
                cnt++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int n = queue.poll();
                    for (int h : list[n]) {
                        if (!check[h]) {
                            queue.add(h);
                            check[h] = true;
                        }
                    }
                }
            }
        }
        System.out.print(cnt);

    }
}
