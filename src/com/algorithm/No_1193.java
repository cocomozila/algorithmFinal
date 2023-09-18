package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int index = 0;
        int sum = 0;
        int move;
        while (true) {
            index += 1;
            sum += index;
            if (sum >= N) {
                break;
            }
        }
        move = sum - N;
        if (index % 2 != 0) {
            System.out.println((1 + move) + "/" + (index - move));
        } else {
            System.out.println((index - move) + "/" + (1 + move));
        }
    }
}
