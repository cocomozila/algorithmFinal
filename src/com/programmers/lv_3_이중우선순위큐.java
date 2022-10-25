package com.programmers;

import java.util.*;

public class lv_3_이중우선순위큐 {

    public static void main(String[] args) {

        lv_3_이중우선순위큐 aa = new lv_3_이중우선순위큐();

        String[] arr = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] arr2 = aa.solution(arr);
        System.out.println(arr2[0]+" "+arr2[1]);
    }

    public int[] solution(String[] operations) {

        StringTokenizer st;
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int size = operations.length;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(operations[i]);
            String order = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch (order) {
                case "I":
                    minQueue.add(num);
                    maxQueue.add(num);
                    break;
                case "D":
                    try {
                        if (num == 1) {
                            int poll = maxQueue.poll();
                            minQueue.remove(poll);
                        } else {
                            int poll = minQueue.poll();
                            maxQueue.remove(poll);
                        }
                    }
                    catch (Exception e) {
                        continue;
                    }
            }
        }
        if (!minQueue.isEmpty()) {
            return new int[]{maxQueue.peek(), minQueue.peek()};
        }
        return new int[]{0, 0};

    }
}
