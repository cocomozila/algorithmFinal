package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_11279 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number != 0) {
                queue.add(number);

            } else {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");

                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());

    }
}
