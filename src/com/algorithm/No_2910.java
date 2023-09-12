package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Node> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int rank = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (map.containsKey(number)) {
                map.put(number, map.get(number).addNumberCount());
            } else {
                map.put(number, new Node(number, 1, rank));
                rank += 1;
            }
        }

        Queue<Node> queue = new PriorityQueue<>();
        for (Node node : map.values()) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < poll.numberCount; i++) {
                sb.append(poll.number).append(" ");
            }
        }
        System.out.println(sb.toString());


    }

    static class Node implements Comparable<Node> {
        int number;
        int numberCount;
        int rank;

        Node(int number, int numberCount, int rank) {
            this.number = number;
            this.numberCount = numberCount;
            this.rank = rank;
        }

        public Node addNumberCount() {
            this.numberCount += 1;
            return this;
        }

        @Override
        public int compareTo(Node o) {
            if (this.numberCount > o.numberCount) {
                return -1;
            } else if (this.numberCount < o.numberCount) {
                return 1;
            } else {
                if (this.rank > o.rank) {
                    return 1;
                } else if (this.rank < o.rank) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
