package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long count = 0;
        long index = 1;
        while (true) {
            if (N - index < 0) {
                break;
            }
            N -= index;
            index += 1;
            count += 1;
        }
        System.out.println(count);
    }
}
