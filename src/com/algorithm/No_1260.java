package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1260 {

    static int N, M, V;
    static TreeSet<Integer>[] list;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new TreeSet[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new TreeSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        check = new boolean[N+1];
        DFS(V);
        sb.append("\n");
        check = new boolean[N+1];
        BFS(V);
        System.out.print(sb);
    }

    public static void DFS(int depth) {
        if (!check[depth]) {
            check[depth] = true;
            sb.append(depth).append(" ");

            for (int a : list[depth]) {
                DFS(a);
            }
        }
    }

    public static void BFS(int depth) {
        if (!check[depth]) {
            check[depth] = true;
            sb.append(depth).append(" ");

            for (int a : list[depth]) {
                queue.add(a);
            }
            while (!queue.isEmpty()) {
                BFS(queue.poll());
            }
        }
    }
}
