package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sumCount = 1;

        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }


        int leftPointer = 1;
        int rightPointer = 1;
        int sum = 0;
        while (rightPointer < (N / 2 + 3)) {
            if (sum < N) {
                sum += rightPointer;
                rightPointer += 1;
            } else if (sum > N) {
                sum -= leftPointer;
                leftPointer += 1;
            } else {
                sum += rightPointer;
                rightPointer += 1;
                sumCount += 1;
            }
        }
        System.out.println(sumCount);
    }
}
