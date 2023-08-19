package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1976 {

    static int N;
    static int M;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = 0;
            while (st.hasMoreTokens()) {
                number += 1;
                int num = Integer.parseInt(st.nextToken());
                if (isVisitCity(num)) {
                    if (i < number) {
                        union(i, number);
                    } else {
                        union(number, i);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = parents[Integer.parseInt(st.nextToken())];
        while (st.hasMoreTokens()) {
            int city = Integer.parseInt(st.nextToken());
            if (parents[city] != root) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    private static void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        if (aRoot > bRoot) {
            parents[aRoot] = bRoot;
        } else if (aRoot < bRoot) {
            parents[bRoot] = aRoot;
        }
    }

    private static int getRoot(int number) {
        if (number == parents[number]) {
            return number;
        }
        return parents[number] = getRoot(parents[number]);
    }

    private static boolean isVisitCity(int number) {
        return number == 1;
    }
}
