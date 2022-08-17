package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No_1967 {

    static ArrayList<Integer> [] list;
    static boolean [] b1;
    static boolean [] b2;
    static int max = 0;
    static int compare = 0;
    static int save = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        b1 = new boolean[N+1];
        b2 = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[a].add(c);
            list[b].add(a);
            list[b].add(c);
        }
        b1[1] = true;
        dfs(list[1], b1);
        b2[save] = true;
        dfs(list[save], b2);

        System.out.println(max);
    }

    public static void dfs(ArrayList<Integer> arr, boolean[] check) {

        for (int i = 0; i < arr.size(); i+=2) {
            if (!check[arr.get(i)]) {
                check[arr.get(i)] = true;
                compare += arr.get(i+1);
                if (max < compare) {
                    max = compare;
                    save = arr.get(i);
                }
                dfs(list[arr.get(i)], check);
                compare -= arr.get(i+1);
            }
        }
    }
}
