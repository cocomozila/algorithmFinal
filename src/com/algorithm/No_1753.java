package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1753 {

    static ArrayList<Node>[] list;
    static boolean[] check;
    static int[] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        check = new boolean[V + 1];
        DP = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
            DP[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        dijkstra(startNode);
        for (int i = 1; i < DP.length; i++) {
            if (DP[i] == Integer.MAX_VALUE - 1) {
                sb.append("INF").append("\n");
            } else {
                sb.append(DP[i]).append("\n");
            }
        }
        System.out.print(sb.toString());

    }

    static private void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        DP[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int t = node.target;

            if (check[t]) {
                continue;
            }

            check[t] = true;
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
