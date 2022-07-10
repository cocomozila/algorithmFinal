package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2525 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        b = b + c;
        while ( b >= 60 ) {
            a++;
            b = b - 60;
            if ( a >= 24 ) {
                a = 0;
            }
        }
        sb.append(a).append(" ").append(b);
        System.out.println(sb);
    }
}
