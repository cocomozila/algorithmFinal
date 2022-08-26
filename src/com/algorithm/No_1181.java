package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Word> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(new Word(br.readLine()));
        }

        for (int i = 0; i < N; i++) {
            if (queue.size() == 1) {
                sb.append(queue.poll().word).append("\n");
                break;
            }
            String str = queue.poll().word;
            if (str.equals(queue.peek().word)) {
                continue;
            }
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }

    static class Word implements Comparable<Word>{
        String word;
        int score;

        public Word(String word) {
            this.word = word;
            this.score = word.length();
        }

        @Override
        public int compareTo(Word o) {
            if (this.score == o.score) {
                for (int i = 0; i < this.word.length(); i++) {
                    if (this.word.charAt(i) != o.word.charAt(i)) {
                        return this.word.charAt(i) - o.word.charAt(i);
                    }
                }
            }
            return this.score - o.score;
        }
    }
}
