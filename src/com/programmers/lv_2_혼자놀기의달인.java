package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class lv_2_혼자놀기의달인 {

    static boolean[] isOpen;
    static int[] newCards;
    static int count = 0;
    static int boxGroupCount = 0;

    public static void main(String[] args) {
        lv_2_혼자놀기의달인 a = new lv_2_혼자놀기의달인();
        int[] cards = {8,6,3,7,2,5,1,4};
        int[] cards2 = {8,7,3,4,5,6,1,2};
        System.out.println(a.runSolution(cards));
        System.out.println(a.runSolution(cards2));


    }

    private int runSolution(int[] arr) {
        return solution(arr);
    }

    public int solution(int[] cards) {

        int length = cards.length;
        newCards = cards;
        isOpen = new boolean[length];
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < cards.length; i++) {
            if (!isOpen[i]) {
                openBox(i);
                queue.add(count);
                count = 0;
                boxGroupCount += 1;
            }
        }

        if (boxGroupCount == 1) {
            return 0;
        }

        return queue.poll() * queue.poll();
    }

    private void openBox(int index) {
        if (!isOpen[index]) {
            isOpen[index] = true;
            openBox(newCards[index] - 1);
            count += 1;
        }
    }
}
