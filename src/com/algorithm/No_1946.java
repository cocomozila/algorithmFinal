package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int [] arr1;
        int [] arr2;
        int cnt = 1;

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            arr1 = new int[N+1];
            arr2 = new int[N+1];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr1[a] = b;
                arr2[b] = a;
            }
            int deadLine = arr1[1];
            int standard = arr2[1];
            for (int j = 1; j <= deadLine; j++) {
                if (standard > arr2[j]) {
                    cnt++;
                    standard = arr2[j];
                }
            }
            sb.append(cnt).append("\n");
            cnt = 1;
        }
        System.out.print(sb);
    }
}
