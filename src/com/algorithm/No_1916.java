package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1916 {

    static int N, M;
    static ArrayList<Node> [] list;
    static boolean [] check;
    static int [] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];
        DP = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            DP[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(DP[finish]);
    }

    static public void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        DP[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int t = node.target;

            if (check[t]) continue;

            check[node.target] = true;
            for (Node n : list[t]) {
                if (DP[n.target] >= DP[t] + n.cost) {
                    DP[n.target] = DP[t] + n.cost;
                    queue.add(new Node(n.target, DP[n.target]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        int target;
        int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
