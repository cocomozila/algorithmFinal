package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int strSize = str.length();
        int[] table = new int[L];

        int idx = 0;
        for (int i = 1; i < strSize; i++) {
            while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
                idx = table[idx-1];
            }
            if (str.charAt(i) == str.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
        System.out.print(L - table[table.length-1]);
    }
}
