package com.programmers;

import java.util.Map;
import java.util.TreeMap;

public class lv_3_인사고과 {

    public static void main(String[] args) {
        lv_3_인사고과 a = new lv_3_인사고과();
        int[][] quiz = {{7,2},{1,4},{3,2},{3,2},{2,1},{5,1},{4,1},{2,5},{4,3}};
        int[][] quiz2 = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        int[][] quiz3 = {{1,1},{1,2},{1,3},{1,4},{1,5}};
        int solution = a.solution(quiz2);
        System.out.println(solution);
    }

    public int solution(int[][] scores) {

        int[] standardX = new int[100000 + 1];
        int[] standardY = new int[100000 + 1];
        int answer = 1;

        // 기준값 만들기
        for (int i = 0; i < scores.length; i++) {
            int a = scores[i][0];
            int b = scores[i][1];

            if (standardX[a] < b) {
                standardX[a] = b;
            }
            if (standardY[b] < a) {
                standardY[b] = a;
            }
        }

        // 기준값 정렬
        for (int i = standardX.length - 1; i > 0; i--) {
            if (standardX[i] > standardX[i - 1]) {
                standardX[i - 1] = standardX[i];
            }
            if (standardY[i] > standardY[i - 1]) {
                standardY[i - 1] = standardY[i];
            }
        }

        int wanhoScore1 = scores[0][0];
        int wanhoScore2 = scores[0][1];
        int wanhoScoreTotal = wanhoScore1 + wanhoScore2;
        if (standardX[wanhoScore1] > wanhoScore2 && standardY[wanhoScore2] > wanhoScore1) {
            return -1;
        }

        TreeMap<Integer, Integer> rank = new TreeMap<>();
        for (int i = 0; i < scores.length; i++) {
            int a = scores[i][0];
            int b = scores[i][1];
            int sum = a + b;

            if (standardX[a] > b && standardY[b] > a) {
                continue;
            }
            if (rank.containsKey(a+b)) {
                rank.put(a+b, rank.get(a+b) + 1);
            } else {
                rank.put(a+b, 1);
            }
        }

        while (rank.size() > 0) {
            Map.Entry<Integer, Integer> entry = rank.pollLastEntry();
            if (entry.getKey() == wanhoScoreTotal) {
                return answer;
            }
            answer += entry.getValue();
        }

        return answer;
    }
}
