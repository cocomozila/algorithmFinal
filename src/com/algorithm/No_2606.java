package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_2606 {

    static int computerNumber;
    static ArrayList<Integer>[] graph;
    static boolean[] check;
    static int count = 0;


    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerNumber = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[computerNumber + 1];
        check = new boolean[computerNumber + 1];

        for (int i = 0; i < computerNumber + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);

        if (count <= 0) {
            System.out.println(0);
            return;
        }
        System.out.println(count - 1);
    }

    public static void DFS(int node) {
        for (int i = 0; i < graph[node].size(); i++) {
            if (!check[graph[node].get(i)]) {
                check[graph[node].get(i)] = true;
                count += 1;
                DFS(graph[node].get(i));
            }
        }
    }
}
