package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No_10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Member> queue = new PriorityQueue();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll().ageAndName + "\n");
        }
        System.out.println(sb.toString());
    }

    static class Member implements Comparable<Member> {
        int id;
        int age;
        String name;
        String ageAndName;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
            this.ageAndName = age + " " + name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age < o.age) {
                return -1;
            } else if (this.age == o.age) {
                if (this.id < o.id) {
                    return -1;
                }
            }
            return 1;
        }
    }
}
