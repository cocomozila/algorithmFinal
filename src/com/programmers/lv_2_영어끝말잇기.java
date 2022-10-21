package com.programmers;

import java.util.TreeSet;

public class lv_2_영어끝말잇기 {

    public static void main(String[] args) {
        lv_2_영어끝말잇기 s = new lv_2_영어끝말잇기();
        String[] str = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] arr = s.solution(3, str);
        System.out.println(arr[0]+", "+arr[1]);
    }

    public int[] solution(int n, String[] words) {

        int size = words.length;
        TreeSet<String> set = new TreeSet<>();

        int cnt = 1;
        int round = 1;
        char lastWord = words[0].charAt(words[0].length()-1);
        set.add(words[0]);

        for (int i = 1; i < size; i++) {
            cnt++;
            set.add(words[i]);
            if (cnt == n+1) {
                cnt = 1;
                round++;
            }
            if (set.size() == i || lastWord != words[i].charAt(0)) {
                return new int[]{cnt, round};
            }
            lastWord = words[i].charAt(words[i].length()-1);
        }
        return new int[]{0, 0};
    }
}
