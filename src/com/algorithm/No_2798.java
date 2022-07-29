package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class No_2798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());

        for ( int i = 0; i < array.length; i++ ) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        for ( int i = 0; i < array.length-2; i++ ) {
            for ( int j = i+1; j < array.length-1; j++ ) {
                for ( int k = j+1; k < array.length; k++ ) {
                    if ( array[i] + array[j] + array[k] > total && array[i] + array[j] + array[k] <= m ) {
                        total = array[i] + array[j] + array[k];
                    }
                }
            }
        }
        System.out.println(total);
    }
}
