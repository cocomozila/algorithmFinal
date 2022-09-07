package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5430 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            try {
                String func = br.readLine();
                int N = Integer.parseInt(br.readLine());
                String arr = br.readLine();
                arr = arr.substring(1, arr.length()-1);
                String[] array = arr.split(",");

                int front = 0;
                int back = N-1;
                boolean isReverse = true;
                boolean [] check = new boolean[N];
                int t = func.length();


                for (int j = 0; j < t; j++) {
                    if (func.charAt(j) == 'R') {
                        isReverse = !isReverse;
                    } else {
                        if (isReverse) {
                            check[front] = true;
                            front++;
                        } else {
                            check[back] = true;
                            back--;
                        }
                    }
                }
                if (isReverse) {
                    sb.append("[");
                    for (int j = 0; j < N; j++) {
                        if (!check[j]) {
                            sb.append(array[j]).append(",");
                        }
                    }
                    if (sb.charAt(sb.length()-1) != '[') {
                        sb.deleteCharAt(sb.length()-1);
                    }
                    sb.append("]").append("\n");
                } else {
                    sb.append("[");
                    for (int j = N - 1; j >= 0; j--) {
                        if (!check[j]) {
                            sb.append(array[j]).append(",");
                        }
                    }
                    if (sb.charAt(sb.length()-1) != '[') {
                        sb.deleteCharAt(sb.length()-1);
                    }
                    sb.append("]").append("\n");
                }
            } catch (Exception e) {
                sb.append("error").append("\n");
            }
        }
        System.out.print(sb);

    }
}
