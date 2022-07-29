package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_6549 {

    static StringTokenizer st;
    static int[] array;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = null;

        while ( !((str = br.readLine()).equals("0")) ) {
            st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            array = new int[n];

            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void DaC () {

        for (int i = 0; i < n; i++) {

        }
    }
}
