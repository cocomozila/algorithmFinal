package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1107 {

    static int goal;
    static int minAnswer;
    static int n;
    static ArrayList<Integer> validNumber = new ArrayList<>();
    static boolean[] brokenButton;
    static int[] number;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goal = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        brokenButton = new boolean[10];
        minAnswer = Math.abs(goal - 100);

        if (n == 0) {
            int answer = Math.min(String.valueOf(goal).length(), minAnswer);
            System.out.println(answer);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            brokenButton[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!brokenButton[i]) {
                validNumber.add(i);
            }
        }
        getClosestNumber(validNumber);
        System.out.println(minAnswer);

    }

    private static void getClosestNumber(List<Integer> validNumbers) {
        int digit = String.valueOf(goal).length();
        if (digit != 1) {
            for (int i = -1; i < 2; i++) {
                number = new int[digit + i];
                DFS(0, digit + i);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                number = new int[digit + i];
                DFS(0, digit + i);
            }
        }
    }

    private static void DFS(int depth, int digit) {
        if (depth == digit) {
            int findNumber = getFindNumber(number);
            minAnswer = Math.min(minAnswer, Math.abs(goal - findNumber) + digit);
            return;
        }

        for (int i = 0; i < validNumber.size(); i++) {
            number[depth] = validNumber.get(i);
            DFS(depth + 1, digit);
        }
    }

    private static int getFindNumber(int[] number) {
        String findNumber = Arrays.toString(number).replace(",", "").replace(" ", "").replace("[", "").replace("]", "");
        if (findNumber.equals("")) {
            return 0;
        }
        return Integer.parseInt(findNumber);
    }
}
