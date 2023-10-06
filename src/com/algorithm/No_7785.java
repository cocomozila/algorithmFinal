package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_7785 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> map = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter")) {
                map.put(name, true);
            } else {
                map.remove(name);
            }
        }
        Set<String> names = map.keySet();
        String[] objects = names.toArray(new String[names.size()]);
        Arrays.sort(objects);
        StringBuilder sb = new StringBuilder();
        for (int i = objects.length - 1; i >= 0; i--) {
            sb.append(objects[i]).append("\n");
        }
        System.out.println(sb.toString());

    }
}