package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 섬의 개수
 *
 * 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
 * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.  *
 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
 */


public class No_4963 {

    static int[] moveX = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] moveY = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[][] map;
    static boolean[][] check;
    static int width;
    static int height;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        while (width != 0 && height != 0) {

            int answer = 0;
            map = new int[height][width];
            check = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    DFS(i, j);
                    if (count > 0) {
                        answer += 1;
                        count = 0;
                    }
                }
            }
            sb.append(answer + "\n");
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb.toString());
    }

    private static void DFS(int y, int x) {
        if (isValidate(y, x)) {
            check[y][x] = true;
            count += 1;
            for (int i = 0; i < moveX.length; i++) {
                DFS(y + moveY[i], x + moveX[i]);
            }
        }
    }

    private static boolean isValidate(int y, int x) {
        return x >= 0 && y >= 0 && x < width && y < height && !check[y][x] && isOne(y, x);
    }

    private static boolean isOne(int y, int x) {
        return map[y][x] == 1;
    }
}
