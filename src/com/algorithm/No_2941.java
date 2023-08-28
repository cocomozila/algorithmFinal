package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] croatia = {"c=".toCharArray(), "c-".toCharArray(), "dz=".toCharArray(), "d-".toCharArray(), "lj".toCharArray(), "nj".toCharArray(), "s=".toCharArray(), "z=".toCharArray()};
        char[] alphabet = br.readLine().toCharArray();
        int count = 0;

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < croatia.length; j++) {
                if (alphabet[i] == croatia[j][0]) {
                    int index = 1;
                    while (index < croatia[j].length) {
                        if (validIndex(alphabet.length, i + index) && alphabet[i + index] == croatia[j][index]) {
                            if (index == croatia[j].length - 1) {
                                i += index;
                                break;
                            }
                            index += 1;
                        } else {
                            break;
                        }
                    }
                }
            }
            count += 1;
        }
        System.out.println(count);
    }

    private static boolean validIndex(int totalIndex, int index) {
        return totalIndex > index;
    }
}
