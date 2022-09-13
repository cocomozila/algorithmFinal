package com.programmers;

public class lv_3_기지국설치 {

    public static void main(String[] args) {

        int[] stations1 = {1};
        System.out.println(10/5);
//        System.out.println(solution(9, stations1, 2));
    }

    public static int solution (int n, int[] stations, int w) {

        int answer = 0;
        double range = (w*2)+1;
        int num = 0;

        int s = stations.length;
        int b = 0;
        for (int i = 0; i < s; i++) {
            int a = stations[i]-1-w;
            b = stations[i]+w;

            answer += Math.ceil((a-num)/range);
            num = b;
        }
        if (num < n) {
            answer += Math.ceil((n-num)/range);
        }
        return answer;
    }
}
