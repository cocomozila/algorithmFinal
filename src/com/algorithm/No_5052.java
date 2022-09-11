package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_5052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];

            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);

            boolean check = true;
            for (int j = N-1; j > 0; j--) {
                if (arr[j].startsWith(arr[j-1])) {
                    sb.append("NO").append("\n");
                    check = false;
                    break;
                }
            }
            if (check) {
                sb.append("YES").append("\n");
            }
        }
        System.out.print(sb);
    }
}
