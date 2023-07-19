package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속합2
 *
 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 * 단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다) *
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 수를 제거하지 않았을 때의 정답은 12+21인 33이 정답이 된다.
 * 만약, -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 여기서 정답은 10-4+3+1+5+6+12+21인 54가 된다.
 */

public class No_13398 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[][] DP = new int[2][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[1];
        DP[1][1] = arr[1];
        for (int i = 1; i <= n; i++) {
            if (arr[i] + DP[0][i - 1] <= 0) {
                DP[0][i] = arr[i];
            } else {
                DP[0][i] = Math.max(arr[i] + DP[0][i - 1], arr[i]);
            }
            max = Math.max(max, DP[0][i]);
            if (i >= 2) {
                DP[1][i] = Math.max(DP[0][i - 2], DP[1][i - 1]) + arr[i];
                max = Math.max(max, DP[1][i]);
            }
        }

        System.out.print(max);
    }
}
