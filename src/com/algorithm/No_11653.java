package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11653 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        answer(n);
    }

    public static void answer ( int a ) {
        if ( a == 1 ) {
            return;
        }
        int x = a;
        for ( int i = 2; i <= a; i++ ) {
            if ( x % i != 0 ) {
                continue;
            }
            x = x/i;
            System.out.println(i);
            i--;
        }
    }
}
