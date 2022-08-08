package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1475 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int max = 0;
        int [] arr = new int[9];

        for (int i = 0; i < str.length(); i++) {
            if (Character.getNumericValue(str.charAt(i)) == 9) {
                arr[6]++;
            } else {
                arr[Character.getNumericValue(str.charAt(i))]++;
            }
        }
        arr[6] = (int)Math.ceil((double)arr[6]/2);

        for (int i = 0; i < 9; i++) {
            max = Math.max(arr[i], max);
        }

        System.out.println(max);

    }
}
