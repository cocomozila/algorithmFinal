package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_1927 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else {
                queue.add(n);
            }
        }
        System.out.println(sb);
    }
}
