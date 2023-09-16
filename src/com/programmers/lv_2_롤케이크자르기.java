package com.programmers;

import java.util.HashSet;

public class lv_2_롤케이크자르기 {

    public static void main(String[] args) {
        lv_2_롤케이크자르기 a = new lv_2_롤케이크자르기();
        int[] arr = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] arr2 = {1, 2, 3, 1, 4};
        System.out.println(a.solution(arr));
        System.out.println(a.solution(arr2));
    }

    public int solution(int[] topping) {

        int answer = 0;

        if (topping.length == 1) {
            return 0;
        }

        int[] rightNumbers = new int[10001];
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();

        leftSet.add(topping[0]);

        for (int i = 1; i < topping.length; i++) {
            rightSet.add(topping[i]);
            rightNumbers[topping[i]] += 1;
        }

        for (int i = 1; i < topping.length; i++) {
            if (leftSet.size() == rightSet.size()) {
                answer += 1;
            }
            int selectNumber = topping[i];
            leftSet.add(selectNumber);
            rightNumbers[selectNumber] -= 1;
            if (rightNumbers[selectNumber] <= 0) {
                rightSet.remove(selectNumber);
            }
        }
        return answer;
    }
}
