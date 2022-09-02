package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No_1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        String [] arr = new String[N+1];

        for (int i = 1; i < N+1; i++) {
            String str = br.readLine();
            map.put(str.hashCode(), i);
            arr[i] = str;
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            try {
                int a = Integer.parseInt(str);
                sb.append(arr[a]).append("\n");

            } catch (NumberFormatException e) {
                sb.append(map.get(str.hashCode())).append("\n");
            }
        }
        System.out.print(sb);
    }
}
