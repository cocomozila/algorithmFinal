package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_13422 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < caseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int houseCount = Integer.parseInt(st.nextToken());
            int stealCount = Integer.parseInt(st.nextToken());
            int deadLine = Integer.parseInt(st.nextToken());
            int answer = 0;

            int[] houses = new int[houseCount];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < houseCount; j++) {
                houses[j] = Integer.parseInt(st.nextToken());
            }

            int totalStealMoney = 0;
            for (int j = 0; j < stealCount; j++) {
                totalStealMoney += houses[j];
            }

            if (houseCount == stealCount) {
                if (totalStealMoney < deadLine) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                continue;
            }

            int index = 0;
            for (int j = 0; j < houseCount; j++) {
                if (j + stealCount >= houseCount) {
                    totalStealMoney += houses[index];
                    index += 1;
                } else {
                    totalStealMoney += houses[j + stealCount];
                }
                totalStealMoney -= houses[j];
                if (totalStealMoney < deadLine) {
                    answer += 1;
                }
            }

            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}
