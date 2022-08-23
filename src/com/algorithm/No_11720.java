package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println(total);
    }
}
