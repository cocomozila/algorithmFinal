package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_1431 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Serial> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(new Serial(br.readLine()));
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll().getSerial()).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class Serial implements Comparable<Serial> {

        String serial;
        int length;
        int totalDigit;

        public Serial(String serial) {
            this.serial = serial;
            this.length = serial.length();

            char[] chars = serial.toCharArray();
            int digitSum = 0;
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    digitSum += Integer.parseInt(String.valueOf(chars[i]));
                }
            }
            this.totalDigit = digitSum;
        }

        public String getSerial() {
            return serial;
        }

        @Override
        public int compareTo(Serial o) {
            if (this.length > o.length) {
                return 1;
            } else if (this.length == o.length) {
                if (this.totalDigit > o.totalDigit) {
                    return 1;
                } else if (this.totalDigit == o.totalDigit) {
                    String[] rank = new String[2];
                    rank[0] = this.serial;
                    rank[1] = o.serial;

                    Arrays.sort(rank);
                    if (rank[0].equals(this.serial)) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
