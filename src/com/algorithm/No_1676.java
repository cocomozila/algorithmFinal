package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No_1676 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger big = new BigInteger("1");
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            big = big.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = big.toString().length()-1; i >= 0; i--) {
            if (big.toString().charAt(i) == '0') {
                cnt++;
                continue;
            }
            break;
        }
        System.out.println(cnt);

    }
}
