package com.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class lv_2_광물캐기 {

    public static void main(String[] args) {
        lv_2_광물캐기 a = new lv_2_광물캐기();
        int[] pick = {1,3,2};
        String[] str = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println("정답 : " + a.solution(pick, str));

        int[] pick2 = {1,1,0};
        String[] str2 = {"stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"};
        System.out.println("정답 : " + a.solution(pick2, str2));
    }


    public int solution(int[] picks, String[] minerals) {

        int answer = 0;

        int graphSize;
        int picksTotal = (picks[0] + picks[1] + picks[2]) * 5;
        if (minerals.length % 5 == 0) {
            graphSize = (minerals.length / 5);
        } else {
            graphSize = (minerals.length / 5) + 1;
        }
        Fatigue[] fatigueArray = new Fatigue[graphSize];

        for (int i = 0; i < graphSize; i++) {
            fatigueArray[i] = new Fatigue();
        }

        int fiveCount = 0;

        int iterCount = Math.min(picksTotal, minerals.length);
        for (int i = 0; i < iterCount; i++) {
            if (i != 0 && i % 5 == 0) {
                fiveCount += 1;
            }
            fatigueArray[fiveCount].setFatigue(minerals[i]);
        }

        PriorityQueue<Fatigue> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < fatigueArray.length; i++) {
            queue.add(fatigueArray[i]);
        }
        Fatigue d = queue.peek();

        while (!queue.isEmpty()) {
            if (picks[0] > 0) {
                answer += queue.poll().getDiamond();
                picks[0] -= 1;
                continue;
            }
            if (picks[1] > 0) {
                answer += queue.poll().getIron();
                picks[1] -= 1;
                continue;
            }
            answer += queue.poll().getStone();
            picks[2] -= 1;
        }

        return answer;
    }

    static class Fatigue implements Comparable<Fatigue> {

        int diamond;
        int iron;
        int stone;

        public void setFatigue(String minerals) {
            if (minerals.equals("diamond")) {
                this.setDiamond(this.getDiamond() + 1);
                this.setIron(this.getIron() + 5);
                this.setStone(this.getStone() + 25);
            } else if (minerals.equals("iron")) {
                this.setDiamond(this.getDiamond() + 1);
                this.setIron(this.getIron() + 1);
                this.setStone(this.getStone() + 5);
            } else {
                this.setDiamond(this.getDiamond() + 1);
                this.setIron(this.getIron() + 1);
                this.setStone(this.getStone() + 1);
            }
        }

        public int getDiamond() {
            return diamond;
        }

        public void setDiamond(int diamond) {
            this.diamond = diamond;
        }

        public int getIron() {
            return iron;
        }

        public void setIron(int iron) {
            this.iron = iron;
        }

        public int getStone() {
            return stone;
        }

        public void setStone(int stone) {
            this.stone = stone;
        }

        @Override
        public int compareTo(Fatigue o) {
            if (this.stone > o.stone) {
                return 1;
            } else if (this.stone == o.stone) {
                if (this.iron > o.iron) {
                    return 1;
                } else if (this.iron == o.iron) {
                    if (this.diamond > o.diamond) {
                        return 1;
                    }
                }
            }
            return -1;
        }
    }
}
