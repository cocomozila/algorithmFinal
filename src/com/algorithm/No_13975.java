package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_13975 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long total = 0;
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Long> queue = new PriorityQueue<>();

            for (int j = 0; j < K; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            while (queue.size() > 2) {
                long sum = queue.poll() + queue.poll();
                total += sum;
                queue.add(sum);
            }
            total += queue.poll() + queue.poll();
            sb.append(total).append("\n");
        }
        System.out.print(sb);
    }
}
