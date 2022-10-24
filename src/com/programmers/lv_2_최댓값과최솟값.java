package com.programmers;

import java.util.StringTokenizer;

public class lv_2_최댓값과최솟값 {

    public static void main(String[] args) {
        lv_2_최댓값과최솟값 aa = new lv_2_최댓값과최솟값();
        String str = aa.solution("1 2 3 4");
        System.out.println(str);
    }

    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return min + " " + max;
    }
}
