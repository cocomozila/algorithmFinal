package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_20040 {

    static int N;
    static int M;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!union(a, b)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);

        if (aRoot == bRoot) {
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }

    private static int getRoot(int number) {
        if (number == parents[number]) {
            return number;
        }
        return parents[number] = getRoot(parents[number]);
    }
}
