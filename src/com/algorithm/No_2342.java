package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2342 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;
        int y = 0;
        int min = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                break;
            }
            else {
                int sumX = sum(x, a);
                int sumY = sum(y, a);

                if (sumX > sumY) {
                    y = a;
                }
                else if (sumX < sumY) {
                    x = a;
                }
                else {
                    x = a;
                }
                min += Math.min(sumX, sumY);
            }
        }
        System.out.println(min);
    }

    public static int sum(int x, int a) {
        if (x == 0) return 2;
        else if (x - a == Math.abs(2)) return 4;
        else if (x == a) return 1;
        else return 3;
    }
}
