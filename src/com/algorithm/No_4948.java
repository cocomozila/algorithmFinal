package com.algorithm;

import java.io.*;

public class No_4948 {

    public static boolean array[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        array = new boolean[246913];
        getPrimeNumber();

        int a = 0;
        int total = 0;
        while ( (a = Integer.valueOf(br.readLine())) != 0 ) {
            for ( int i = a+1; i <= a*2; i++ ) {
                if ( !array[i] ) {
                    total += 1;
                }
            }
            bw.write(total+"\n");
            total = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPrimeNumber() {

        array[0] = true;
        array[1] = true;

        for ( int i = 2; i < Math.sqrt(array.length); i++ ) {
            if ( array[i] ) {
                continue;
            }
            for ( int j = i*i; j < array.length; j += i ) {
                array[j] = true;
            }
        }
    }
}
