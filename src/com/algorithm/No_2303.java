package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2303 {

    static int minIndex = 0;
    static int minValue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            arr[3] = Integer.parseInt(st.nextToken());
            arr[4] = Integer.parseInt(st.nextToken());
            cal(arr, i);

        }
        System.out.println(minIndex + 1);
    }

    public static void cal(int[] arr, int index) {
        for (int j = 0; j < 3; j++) {
            for (int k = j + 1; k < 4; k++) {
                for (int l =  k + 1; l < 5; l++) {
                    int value = (arr[j] + arr[k] + arr[l]) % 10;
                    if (minValue <= value) {
                        minIndex = index;
                        minValue = value;
                    }
                }
            }
        }
    }
}
