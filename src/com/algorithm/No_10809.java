package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        int[] alphabet = new int[26];
        StringBuilder sb = new StringBuilder();
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < words.length; i++) {
            char c = words[i];
            if (alphabet[c - 97] == -1) {
                alphabet[c - 97] = i;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
        }
        System.out.println(sb);

    }
}
