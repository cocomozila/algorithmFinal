package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1644 {

    static boolean[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new boolean[N+1];

        getPrimeNumber();

        int j = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N+1; i++) {
            if (!array[i]) {
                sum += i;
                while (sum >= N) {
                    if (!array[j]) {
                        if (sum == N) {
                            cnt++;
                        }
                        sum -= j;
                    }
                    j++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void getPrimeNumber() {

        array[0] = true;
        array[1] = true;

        for ( int i = 2; i < Math.sqrt(array.length); i++ ) {
            if ( array[i] ) {
                continue;
            }
            for ( int j = i*i; j < array.length; j += i ) {
                array[j] = true;
            }
        }
    }
}
