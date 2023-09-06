package com.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class No_2161 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        System.out.println(sb.toString());
    }
}
