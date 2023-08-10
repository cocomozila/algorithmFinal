package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1049 {

    static int N;
    static int M;
    static double minSixPackage = 1001;
    static int minSingle = 1001;
    static int cost = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sixPackage = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());

            minSixPackage = Math.min(minSixPackage, sixPackage);
            minSingle = Math.min(minSingle, single);
        }

        if (minSixPackage/6 >= minSingle) {
            cost = minSingle * N;
        } else {
            while (N > 0) {
                N -= 6;
                cost += minSixPackage;
                if (N < 6 && N > 0) {
                    cost += Math.min(minSixPackage, minSingle * N);
                    N = 0;
                }
            }
        }
        System.out.println(cost);
    }
}
