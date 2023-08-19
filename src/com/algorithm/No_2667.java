package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 단지번호붙이기
 *
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 */

public class No_2667 {

    static int[][] board;
    static boolean[][] check;
    private static final int DIRECTION = 4;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int N;
    static int count;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                DFS(i, j);
                if (count != 0) {
                    queue.add(count);
                    count = 0;
                }
            }
        }

        sb.append(queue.size() + "\n");
        while (!queue.isEmpty()) {
            sb.append(queue.poll() + "\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int y, int x) {
        if (isValidNumber(y, x)) {
            check[y][x] = true;
            count += 1;
            for (int i = 0; i < DIRECTION; i++) {
                DFS(y + moveY[i], x + moveX[i]);
            }
        }
    }

    private static boolean isValidNumber(int y, int x) {
        return x >= 0 && y >= 0 && x < N && y < N && !check[y][x] && isOne(y, x);
    }

    private static boolean isOne(int y, int x) {
        return board[y][x] == 1;
    }
}
