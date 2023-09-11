package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int K = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) {
                count += 1;
                continue;
            }
            map.put(K - a, 1);
        }
        System.out.println(count);

    }
}
