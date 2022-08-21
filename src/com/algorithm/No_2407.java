package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class No_2407 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger b1 = new BigInteger(String.valueOf(n));
        BigInteger b2 = new BigInteger(String.valueOf(m));

        for (int i = 1; i < m; i++) {
            b1 = b1.multiply(BigInteger.valueOf(n-i));
            b2 = b2.multiply(BigInteger.valueOf(m-i));
        }
        System.out.println(b1.divide(b2).toString());
    }
}
