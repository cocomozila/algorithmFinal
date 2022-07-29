package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2447 {

    static char [][] array;
    static int r = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array = new char[n][n];
        answer(n);

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }

    public static int answer (int n) {

        if ( n == 1) {
            return 0;
        }

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( n / 3 <= i && n * 2 / 3 > i && n / 3 <= j && n * 2 / 3 > j ) {
                    array[i][j] = ' ';
                    continue;
                }
                array[i][j] = '*';
            }
        }

        r *= 3;
        answer(n/3);
        return 0;
    }
}
