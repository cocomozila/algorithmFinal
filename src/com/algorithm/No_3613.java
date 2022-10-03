package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3613 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int size = str.length();

        boolean isJava = false;
        boolean isCpp = false;
        boolean fill = false;

        for (int i = 0; i < size; i++) {
            char a = str.charAt(i);
            int num = a;

            if (fill) {
                if (a == '_' || num >= 65 && num <= 90) {
                    System.out.println("Error!");
                    return;
                }
                sb.append((char)(a - ' '));
                fill = false;
                continue;
            }

            if (num >= 65 && num <= 90) {
                if (isCpp || i == 0) {
                    System.out.println("Error!");
                    return;
                }
                isJava = true;
                sb.append("_").append((char)(a + ' '));
                continue;
            }
            if (a == '_') {
                if (isJava || i == size-1 || i == 0) {
                    System.out.println("Error!");
                    return;
                }
                isCpp = true;
                fill = true;
                continue;
            }
            sb.append(a);
        }
        System.out.println(sb);
    }
}
