package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1786 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] table = createTable(str2);
        int str1Length = str1.length();
        int str2Length = str2.length();
        int cnt = 0;

        int j = 0;
        for (int i = 0; i < str1Length; i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = table[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                if (j == str2Length - 1) {
                    cnt++;
                    sb.append(i - str2Length + 2).append(" ");
                    j = table[j];
                }
                else {
                    j++;
                }
            }
        }
        sb.insert(0, cnt+"\n");
        System.out.print(sb);

    }

    public static int[] createTable(String s) {

        int n = s.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i = 1; i < n; i++) {
            while (idx > 0 && s.charAt(i) != s.charAt(idx)) {
                idx = table[idx-1];
            }

            if (s.charAt(i) == s.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }
}
