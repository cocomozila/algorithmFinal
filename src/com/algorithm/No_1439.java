package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[2];

        String str = br.readLine();
        int a = Integer.parseInt(String.valueOf(str.charAt(0)));
        arr[a]++;

        for (int i = 1; i < str.length(); i++) {
            if (Integer.parseInt(String.valueOf(str.charAt(i))) == a) {
                continue;
            } else {
                a = Integer.parseInt(String.valueOf(str.charAt(i)));
                arr[a]++;
            }
        }
        System.out.println(Math.min(arr[0], arr[1]));
    }
}
