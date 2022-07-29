package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2581 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int total = 0;
        int min = 0;
        boolean button = true;

        for ( int i = n; i <= m; i++ ) {
            total = total + isPrimeNumber(i);
            if ( isPrimeNumber(i) > 0 && button == true ) {
                min = isPrimeNumber(i);
                button = false;
            }
        }

        if ( total == 0 ) {
            System.out.println(-1);
        }
        else {
            System.out.println(total+"\n"+min);
        }
    }

    public static int isPrimeNumber (double a) {
        double x = a;

        if ( a == 1 ) {
            return 0;
        }

        for ( double i = 2; i < a; i++ ) {
            if ( (a / i) % 1 == 0 ) {
                return 0;
            }
        }
        return (int)x;
    }
}
