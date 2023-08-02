package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_2015 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<Integer, Long> map = new HashMap<>();
        long count = 0;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());

            if (arr[i] == K) {
                count += 1;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (map.containsKey(arr[i] - K)) {
                count += map.get(arr[i] - K);
            }

            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1L);
            }
        }
        System.out.println(count);
    }
}
