package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            int[] alphabet = new int[26];
            char[] word = br.readLine().toCharArray();
            if (word.length <= 2) {
                total += 1;
                continue;
            }
            for (int j = 0; j < word.length; j++) {
                if (alphabet[word[j]-97] == 0) {
                    alphabet[word[j]-97]++;
                    if (j > 0) {
                        alphabet[word[j-1]-97] = -1;
                    }
                }
                else if (alphabet[word[j]-97] == -1) {
                    total -= 1;
                    break;
                }
            }
            total += 1;
        }
        System.out.println(total);
    }
}
