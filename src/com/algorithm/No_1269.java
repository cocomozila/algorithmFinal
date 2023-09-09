package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1269 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            map.put(st.nextToken(), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            String key = st.nextToken();
            if (map.containsKey(key)) {
                continue;
            }
            map.put(key, 1);
        }

        System.out.println((A + B) - (((A + B) - (map.size())) * 2));
    }
}
