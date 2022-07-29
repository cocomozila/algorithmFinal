package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1978 {

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int total = 0;
    for ( int i = 0; i < n; i++ ) {
        total = total + primeNumber(Integer.parseInt(st.nextToken()));
    }
    System.out.println(total);

    }

    public static int primeNumber (double a) {

        if ( a == 1 ) {
            return 0;
        }

        for ( double i = 2; i < a; i++ ) {
            if ( (a / i) % 1 == 0 ) {
                return 0;
            }
        }
        return 1;
    }
}
