package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_15663 {

    static int N, M;
    static int [] arr;
    static int [] answer;
    static boolean [] node;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        node = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);        
        dfs(0);
        Iterator<String> iter = set.iterator();
        sb = new StringBuilder();
        while(iter.hasNext()) {
            sb.append(iter.next()).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int depth) {

        if (depth == M) {
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            String str = sb.toString();
            set.add(str);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!node[i]) {
                answer[depth] = arr[i];
                node[i] = true;
                dfs(depth + 1);
                node[i] = false;
            }
        }
    }
}
