package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_1302 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String bestSeller = "{}";
        int max = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();

            if (map.containsKey(readLine)) {
                map.put(readLine, map.get(readLine) + 1);
            } else {
                map.put(readLine, 1);
            }

            if (max < map.get(readLine)) {
                max = map.get(readLine);
                bestSeller = readLine;
            } else if (max == map.get(readLine)) {
                String[] strArray = new String[2];
                strArray[0] = bestSeller;
                strArray[1] = readLine;
                Arrays.sort(strArray);
                bestSeller = strArray[0];
            }
        }
        System.out.println(bestSeller);
    }
}
