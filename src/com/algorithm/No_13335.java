package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_13335 {

    static int nowLoad = 0;
    static int n;
    static int bridgeLength;
    static int maximumLoad;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        bridgeLength = Integer.parseInt(st.nextToken());
        maximumLoad = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        int[] trucksPosition = new int[n];
        Arrays.fill(trucksPosition, bridgeLength + 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = 0;
        int endIndex = 0;
        int maxTruckCount = 0;
        int index = 0;
        int count = 0;
        while (true) {
            count += 1;
            if (isValidIndex(index) && isNotOverLoad(trucks[index]) && maxTruckCount < bridgeLength) {
                nowLoad += trucks[index];
                maxTruckCount += 1;
                endIndex += 1;
                index += 1;
            }

            for (int j = startIndex; j < endIndex; j++) {
                if (trucksPosition[j] > 0) {
                    trucksPosition[j] -= 1;
                }
                if (trucksPosition[j] == 1) {
                    startIndex = j;
                    nowLoad -= trucks[j];
                    maxTruckCount -= 1;
                }
            }
            if (trucksPosition[n - 1] == 0) {
                System.out.println(count);
                break;
            }
        }
    }

    private static boolean isValidIndex(int index) {
        return index < n;
    }

    private static boolean isNotOverLoad(int truckWeight) {
        return truckWeight + nowLoad <= maximumLoad;
    }
}
