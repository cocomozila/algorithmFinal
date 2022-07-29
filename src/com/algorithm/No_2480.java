package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2480 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(answer(a,b,c));

    }

    public static int answer (int a, int b, int c) {
        if ( a == b && b == c ) {
            return 10000 + ( a * 1000 );
        }
        if ( a == b || a == c) {
            return  1000 + ( a * 100 );
        }
        if ( b == c ) {
            return  1000 + ( b * 100 );
        }

        int high = 0;
        int [] array = {a, b, c};
        for ( int i = 0; i < 3; i++ ) {
            if ( high < array[i] ) {
                high = array[i];
            }
        }
        return high * 100;
    }
}
