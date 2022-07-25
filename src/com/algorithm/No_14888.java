package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14888 {

    static int[] array;
    static int[] sign;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        sign = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        answer(array[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void answer(int total, int depth) {

        if (depth == n) {
            if (total >= max) {
                max = total;
            }
            if (total <= min) {
                min = total;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (sign[i] > 0) {
                sign[i]--;
                switch (i) {
                    case 0:
                        answer(total + array[depth],depth+1);
                        break;
                    case 1:
                        answer(total - array[depth],depth+1);
                        break;
                    case 2:
                        answer(total * array[depth],depth+1);
                        break;
                    case 3:
                        answer(total / array[depth],depth+1);
                        break;
                }
                sign[i]++;
            }
        }
    }
}
