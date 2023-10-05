package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No_11478 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j + i < str.length()) {
                    String substring = str.substring(j, j + i + 1);
                    set.add(substring);
                }
            }
        }
        System.out.println(set.size());
    }
}
