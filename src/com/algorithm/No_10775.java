package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10775 {

    static int[] parents;
    static int N;
    static int M;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        initParents();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int findNum = find(num);
            if (findNum == 0) {
                break;
            }
            count += 1;
            union(findNum, findNum - 1);
        }
        System.out.println(count);
    }

    private static void initParents() {
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        parents[aRoot] = bRoot;
    }

    private static int find(int number) {
        if (number == parents[number]) {
            return number;
        }
        return parents[number] = find(parents[number]);
    }
}
