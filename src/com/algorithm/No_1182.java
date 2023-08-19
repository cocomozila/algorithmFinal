package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1182 {

    static int N;
    static int S;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum(0, 0);
        if (S == 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }

    private static void sum(int sum, int depth) {
        if (depth == N) {
            if (sum == S) {
                result += 1;
            }
            return;
        }
        sum(sum, depth + 1);
        sum(sum + arr[depth], depth + 1);
    }
}
