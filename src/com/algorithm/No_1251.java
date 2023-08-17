package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No_1251 {

    static String firstWord = "{}";
    static char[] words;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = br.readLine().toCharArray();

        ArrayList<Integer> minIndexs = new ArrayList<>();
        char minChar = 'z' + 1;
        for (int i = 0; i < words.length - 2; i++) {
            if (minChar > words[i]) {
                minIndexs.clear();
                minChar = words[i];
                minIndexs.add(i);
            } else if (minChar == words[i]) {
                minIndexs.add(i);
            }
        }
        for (int i : minIndexs) {
            for (int j = i + 1; j < words.length - 1; j++) {
                findFirstWord(i, j);
            }
        }
        System.out.println(firstWord);
    }

    public static void findFirstWord(int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a; i >= 0; i--) {
            sb.append(words[i]);
        }

        for (int i = b; i > a; i--) {
            sb.append(words[i]);
        }

        for (int i = words.length - 1; i > b; i--) {
            sb.append(words[i]);
        }
        if (firstWord.compareTo(sb.toString()) > 0) {
            firstWord = sb.toString();
        }
    }
}
