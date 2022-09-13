package com.programmers;

import java.util.HashSet;

public class 스킬체크테스트_lv2_2 {

    static boolean[] array = new boolean[10000001];
    static char[] arr;
    static char[] slot;
    static boolean[] check;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution("1086875"));
    }

    public static int solution(String numbers) {
        getPrimeNumber();
        arr = numbers.toCharArray();

        for (int i = 1; i <= arr.length; i++) {
            check = new boolean[arr.length];
            slot = new char[i];
            answer(0, i);
        }

        return set.size();
    }

    public static void answer(int depth, int digit) {

        if (depth == digit) {
            if (!array[Integer.parseInt(String.valueOf(slot))]) {
                System.out.println(Integer.parseInt(String.valueOf(slot)));
                set.add(Integer.parseInt(String.valueOf(slot)));
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                slot[depth] = arr[i];
                answer(depth + 1, digit);
                slot[depth] = 'a';
                check[i] = false;
            }
        }
    }

    public static void getPrimeNumber() {

        array[0] = true;
        array[1] = true;

        for ( int i = 2; i < Math.sqrt(array.length); i++ ) {
            if ( array[i] ) {
                continue;
            }
            for ( int j = i*i; j < array.length; j += i ) {
                array[j] = true;
            }
        }
    }
}
