package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No_1208 {

    static int N;
    static int S;
    static int[] arr;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        createList(0, 0, N/2, leftList);
        createList(0, N/2, N, rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        getResult();
        if (S == 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }

    private static void getResult() {
        int leftIndex = 0;
        int rightIndex = rightList.size() - 1;

        while (true) {
            if (leftIndex == leftList.size() || rightIndex < 0) {
                break;
            }

            int leftValue = leftList.get(leftIndex);
            int rightValue = rightList.get(rightIndex);
            int sum = leftValue + rightValue;

            if (sum < S) {
                leftIndex += 1;

            } else if (sum > S) {
                rightIndex -= 1;

            } else {
                long leftCount = 0;
                while (leftIndex < leftList.size() && leftList.get(leftIndex) == leftValue) {
                    leftCount += 1;
                    leftIndex += 1;
                }
                long rightCount = 0;
                while (0 <= rightIndex && rightList.get(rightIndex) == rightValue) {
                    rightCount += 1;
                    rightIndex -= 1;
                }
                result += leftCount * rightCount;

            }
        }
    }

    private static void createList(int sum, int start, int end, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        createList(sum, start + 1, end, list);
        createList(sum + arr[start], start + 1, end, list);
    }
}
