package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2839 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        System.out.println(answer(a));

    }

    public static int answer (int x) {

        if ( x == 4 || x == 7) {
            return -1;
        }

        int fiveCount = (int)(Math.floor( x / 5 ));

        switch ( x % 5 ) {
            case 0 :
                return fiveCount;
            case 1 : case 3:
                return fiveCount + 1;
            default:
                return fiveCount + 2;
        }
    }
}

