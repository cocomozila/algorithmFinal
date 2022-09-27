package com.programmers;

public class k진수에서소수개수구하기_lv2 {

    public static void main(String[] args) {

        System.out.println(solution(999999, 3));
    }

    public static int solution(int n, int k) {

        String[] str = Long.toString(n, k).split("0");
        int answer = 0;

        for (int i = 0; i < str.length; i++) {
            long a = Long.parseLong(str[i]);
            try {
                if (check(a)) {
                    answer++;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return answer;
    }

    static boolean check(long x){
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }
}
