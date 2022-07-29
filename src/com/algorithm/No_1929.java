package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No_1929 {

    public static boolean array[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        array = new boolean[b+1];
        getPrimeNumber();

        for ( int i = a; i <= b; i++ ) {
            if ( !array[i] ) {
                bw.write(i+"\n");
            }
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
