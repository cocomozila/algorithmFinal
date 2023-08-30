package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_1417 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());
        int count = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            int number = Integer.parseInt(br.readLine());
            queue.add(number);
        }

        while (!queue.isEmpty() && queue.peek() >= dasom) {
            int pollNumber = queue.poll();
            dasom += 1;
            pollNumber -= 1;
            queue.add(pollNumber);
            count += 1;
        }
        System.out.println(count);
    }
}
