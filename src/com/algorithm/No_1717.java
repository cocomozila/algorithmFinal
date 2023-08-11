package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1717 {

    static int[] parents;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        initParents();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isZero(cal)) {
                union(a, b, true);
            } else {
                if (a == b) {
                    sb.append("YES").append("\n");
                } else {
                    union(a, b, false);
                }
            }
        }
        System.out.print(sb.toString());
    }

    private static void initParents() {
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static boolean isZero(int num) {
        return num == 0;
    }

    private static void union(int a, int b, boolean isCal) {
        if (isCal) {
            int aRoot = getRoot(a);
            int bRoot = getRoot(b);

            if (aRoot > bRoot) {
                parents[aRoot] = bRoot;
            } else if (aRoot < bRoot) {
                parents[bRoot] = aRoot;
            }

        } else {
            int aRoot = getRoot(a);
            int bRoot = getRoot(b);

            if (aRoot == bRoot) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
    }

    private static int getRoot(int number) {
        if (number == parents[number]) {
            return number;
        }
        return parents[number] = getRoot(parents[number]);
    }
}
