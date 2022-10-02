package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_12738 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] save = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        list.add(Integer.MIN_VALUE);
        for (int i = 1; i < N +1; i++) {
            int n = arr[i];
            int left = 1;
            int right = list.size()-1;

            if (n > list.get(right)) {
                list.add(n);
                save[i] = list.size()-1;
            }
            else {
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (n <= list.get(mid)) {
                        right = mid;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                list.set(right, n);
                save[i] = right;
            }
        }

        System.out.println(list.size()-1);
    }
}
