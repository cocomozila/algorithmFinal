package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int total = 0;

        if (!str.contains("-")) {
            String [] arr = str.split("\\+");
            for (int i = 0; i < arr.length; i++) {
                total += Integer.parseInt(arr[i]);
            }
            System.out.println(total);

        } else {
            String [] arr = str.split("-");
            for (int j = 0; j < arr.length; j++) {
                String [] arr2 = arr[j].split("\\+");
                int d = 0;
                for (int i = 0; i < arr2.length; i++) {
                    d += Integer.parseInt(arr2[i]);
                }
                if (j == 0) {
                    total += d;
                    continue;
                }
                total -= d;
            }
            System.out.println(total);
        }
    }
}
