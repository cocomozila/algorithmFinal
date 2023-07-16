package com.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class lv_1_달리기경주 {

    public static void main(String[] args) {
        lv_1_달리기경주 a = new lv_1_달리기경주();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(a.solution(players, callings)));

    }

    public String[] solution(String[] players, String[] callings) {

        HashMap<Integer, String> numberToName = new HashMap<>();
        HashMap<String, Integer> nameToNumber = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            numberToName.put(i, players[i]);
            nameToNumber.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String callPlayer = callings[i];
            int rank = nameToNumber.get(callPlayer);
            String prePlayer = numberToName.get(rank - 1);
            numberToName.replace(rank - 1, callPlayer);
            numberToName.replace(rank, prePlayer);
            nameToNumber.replace(callPlayer, rank - 1);
            nameToNumber.replace(prePlayer, rank);
        }

        return numberToName.values().toArray(new String[players.length]);
    }
}
