package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class No_11723 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[20];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int n = 0;

            try {
                n = Integer.parseInt(st.nextToken());
            }
            catch (NoSuchElementException e) {
                if (order.equals("all")) {
                    Arrays.fill(arr, true);
                    continue;
                }
                Arrays.fill(arr, false);
            }

            switch (order) {
                case "add":
                    arr[n-1] = true;
                    break;
                case "remove":
                    arr[n-1] = false;
                    break;
                case "check":
                    if (arr[n-1]) {
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
                case "toggle":
                    if (arr[n-1]) {
                        arr[n-1] = false;
                        break;
                    }
                    arr[n-1] = true;
                    break;
            }
        }
        System.out.print(sb);
    }
}
