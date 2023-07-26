package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연구소
 *
 * 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
 * 연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
 * 일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
 * 예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.
 *
 * 2 0 0 0 1 1 0
 * 0 0 1 0 1 2 0
 * 0 1 1 0 1 0 0
 * 0 1 0 0 0 0 0
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 *
 * 이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
 * 2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.
 *
 * 2 1 0 0 1 1 0
 * 1 0 1 0 1 2 0
 * 0 1 1 0 1 0 0
 * 0 1 0 0 0 1 0
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 *
 * 바이러스가 퍼진 뒤의 모습은 아래와 같아진다.
 *
 * 2 1 0 0 1 1 2
 * 1 0 1 0 1 2 2
 * 0 1 1 0 1 2 2
 * 0 1 0 0 0 1 2
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 *
 * 벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
 * 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
 */

public class No_14502 {

    static int N;
    static int M;
    static int[][] board;
    static int[][] copyBoard;
    static boolean[][] check;
    static final int VIRUS = 2;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static boolean[] wall = new boolean[3];
    static ArrayList<Virus> list = new ArrayList<>();
    static int count;
    static int min = Integer.MAX_VALUE;
    static int safeZones;
    static int wallZones;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (isSafeZone(board[i][j])) {
                    safeZones += 1;
                }
                if (isWallZone(board[i][j])) {
                    wallZones += 1;
                }
                if (board[i][j] == VIRUS) {
                    list.add(new Virus(i, j));
                }
            }
        }
        DFS(0);
        System.out.println((N * M) - min - wallZones - 3);
    }

    private static boolean isWallZone(int zone) {
        return zone == 1;
    }

    private static boolean isSafeZone(int zone) {
        return zone == 0;
    }

    private static void DFS(int wallCount) {
        if (wallCount == wall.length) {
            copyBoard = new int[N][M];
            check = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                copyBoard[i] = Arrays.copyOf(board[i], M);
            }
            spreadVirus();
            return;
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (board[j][k] == 0) {
                    board[j][k] = 1;
                    DFS(wallCount + 1);
                    board[j][k] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        for (Virus virus : list) {
            virusDFS(virus.getY(), virus.getX());
        }
        min = Math.min(min, count);
        count = 0;
    }

    private static void virusDFS(int y, int x) {
        if (checkValidVirus(y, x)) {
            check[y][x] = true;
            copyBoard[y][x] = VIRUS;
            for (int i = 0; i < moveY.length; i++) {
                virusDFS(y + moveY[i], x + moveX[i]);
            }
            count += 1;
        }
    }

    private static boolean checkValidVirus(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M && isValidZone(board[y][x]) && !check[y][x];
    }

    private static boolean isValidZone(int board) {
        return board == 0 || board == 2;
    }

    static class Virus {
        int y;
        int x;

        public Virus(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
