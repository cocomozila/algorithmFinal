package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(answer(a, b, c));
    }

    public static int answer (int a, int b, int c) {
        double oneDay = a - b;
        double total = c - a;

        if ( a >= c ) {
            return 1;
        }
        return (int) (( Math.ceil(total / oneDay) ) + 1);
    }
}
