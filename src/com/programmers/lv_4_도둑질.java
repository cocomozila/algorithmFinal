package com.programmers;

public class lv_4_도둑질 {

    public static void main(String[] args) {

    }

    public static int solution(int[] sticker) {

        int n = sticker.length;
        if (n == 1) {
            return sticker[0];
        } else if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] DP = new int[n];
        int[] DP2 = new int[n];

        DP[0] = sticker[0];
        DP[1] = sticker[1];
        DP[2] = DP[0] + sticker[2];

        DP2[n-1] = sticker[n-1];
        DP2[n-2] = sticker[n-2];
        DP2[n-3] = DP2[n-1] + sticker[n-3];

        for (int i = 3; i < n; i++) {
            DP[i] = Math.max(DP[i-2], DP[i-3]) + sticker[i];
        }

        for (int i = n-4; i >= 0; i--) {
            DP2[i] = Math.max(DP2[i+2], DP2[i+3]) + sticker[i];
        }

        return Math.max(Math.max(DP[n-3], DP[n-2]), Math.max(DP2[1], DP2[2]));
    }
}
