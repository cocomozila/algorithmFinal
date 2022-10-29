package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] p = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        int a = (p[0][0] * p[1][1]) + (p[1][0] * p[2][1]) + (p[2][0] * p[0][1]);
        int b = (p[1][0] * p[0][1]) + (p[2][0] * p[1][1]) + (p[0][0] * p[2][1]);

        if (a - b > 0) {
            System.out.println(1);
            return;
        } else if (a == b) {
            System.out.println(0);
            return;
        }
        System.out.println(-1);
        return;
    }
}
