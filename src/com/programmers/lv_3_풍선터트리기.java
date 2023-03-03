package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class lv_3_풍선터트리기 {

    public static void main(String[] args) {
        lv_3_풍선터트리기 aa = new lv_3_풍선터트리기();
        int[] q1 = {1};
        int[] q2 = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        int[] q3 = {9,7,5,3,1,0,2,4,10,6,8};
        System.out.println(aa.solution(q1));
        System.out.println(aa.solution(q2));
        System.out.println(aa.solution(q3));

    }

    public int solution(int[] a) {
        if (a.length == 2) {
            return 2;
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                count += 1;
            }
        }

        int min2 = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < min2) {
                min2 = a[i];
                count += 1;
            }
        }

        return count - 1;
    }
}
