package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[10000];
        int index = 0;

        for ( int i = 0; i < Integer.MAX_VALUE; i++ ) {
            if ( String.valueOf(i).contains("666") ) {
                array[index] = i;
                index++;
            }
            if (index == n) {
                break;
            }
        }
        System.out.println(array[n-1]);
    }
}
