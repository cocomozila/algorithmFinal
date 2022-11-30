package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_1068 {

    static List<Integer>[] lists;
    static int removeNode;
    static int count = 0;
    static int root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        removeNode = Integer.parseInt(br.readLine());

        lists = new List[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == -1) {
                root = i;
                continue;
            }
            if (i == removeNode || arr[i] == removeNode) {
                continue;
            }
            lists[arr[i]].add(i);
        }

        if (root == removeNode) {
            System.out.println(0);
            return;
        }

        DFS(root);
        System.out.println(count);
    }

    public static void DFS(int depth) {
        if (!lists[depth].isEmpty()) {
            for (int n : lists[depth]) {
                DFS(n);
            }
        }
        else {
            count += 1;
        }
    }
}
