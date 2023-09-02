package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_1544 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            String word = readLine + readLine;
            boolean isFind = false;

            for (int j = 0; j < readLine.length(); j++) {
                String substring = word.substring(j, j + readLine.length());
                int key = substring.hashCode();
                if (map.containsKey(key)) {
                    if (map.get(key) == i) {
                        continue;
                    } else {
                        isFind = true;
                        break;
                    }
                }
                map.put(key, i);
            }
            if (isFind) {
                continue;
            }
            answer += 1;
        }
        System.out.println(answer);

    }

}
