package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4354 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = null;

        while (!(str = br.readLine()).equals(".")) {

            int size = str.length();
            int[] table = new int[size];
            int zeroIndex = 1;

            int idx = 0;
            for (int i = 1; i < size; i++) {
                while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
                    idx = table[idx-1];
                }
                if (str.charAt(i) == str.charAt(idx)) {
                    idx++;
                    table[i] = idx;
                }
                if (table[i] == 0) {
                    zeroIndex = i+1;
                }
                else if (table[i-1] >= table[i]) {
                    zeroIndex = i;

                }
            }
            if (size % zeroIndex != 0) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(size / zeroIndex).append("\n");
            }

        }
        System.out.println(sb);

    }
}
