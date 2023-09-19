package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_14499 {

    static int[][] board;
    static int N, M;
    static final int[] moveY = {0, 0, -1, 1};
    static final int[] moveX = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int diceStartY = Integer.parseInt(st.nextToken());
        int diceStartX = Integer.parseInt(st.nextToken());
        int totalMovement = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(diceStartY, diceStartX);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalMovement; i++) {
            dice.execution(Integer.parseInt(st.nextToken()) - 1);
        }
        dice.printRecords();


    }

    static class Dice {
        /**
         *     _2
         *  _4 _1 _3
         *     _5
         *     _6
         */
        Map<Integer, Integer> value = new HashMap<>();
        StringBuilder records = new StringBuilder();

        int y;
        int x;

        int top = 1;
        int bottom = 6;
        int left = 4;
        int right = 3;
        int front = 2;
        int back = 5;

        Dice(int y, int x) {
            this.y = y;
            this.x = x;
            value.put(1, 0);
            value.put(2, 0);
            value.put(3, 0);
            value.put(4, 0);
            value.put(5, 0);
            value.put(6, 0);
        }

        void execution(int direction) {
            if (!isValidCommand(y + moveY[direction], x + moveX[direction])) {
                return;
            }
            moveCoordinate(direction);

            if (direction == 0) {
                moveEast();
            } else if (direction == 1) {
                moveWest();
            } else if (direction == 2) {
                moveNorth();
            } else {
                moveSouth();
            }

            if (currentBoardIsZero()) {
                copyDiceToBoard();
            } else {
                copyBottom();
                deleteCurrentLocation();
            }
            record();
        }

        private boolean isValidCommand(int y, int x) {
            return y >= 0 && x >= 0 && y < N && x < M;
        }

        private void moveCoordinate(int direction) {
            this.y += moveY[direction];
            this.x += moveX[direction];
        }

        private void record() {
            records.append(value.get(top)).append("\n");
        }

        public void printRecords() {
            System.out.print(records.toString());
        }

        private void copyDiceToBoard() {
            board[y][x] = value.get(bottom);
        }

        private boolean currentBoardIsZero() {
            return board[y][x] == 0;
        }

        private void copyBottom() {
            value.put(bottom, board[y][x]);
        }

        private void deleteCurrentLocation() {
            board[y][x] = 0;
        }

        private void moveEast() {
            int bottomCopy = bottom;
            int topCopy = top;
            bottom = right;
            top = left;
            left = bottomCopy;
            right = topCopy;
        }

        private void moveWest() {
            int bottomCopy = bottom;
            int topCopy = top;
            bottom = left;
            top = right;
            left = topCopy;
            right = bottomCopy;
        }

        private void moveNorth() {
            int bottomCopy = bottom;
            int topCopy = top;
            bottom = front;
            top = back;
            front = topCopy;
            back = bottomCopy;
        }

        private void moveSouth() {
            int bottomCopy = bottom;
            int topCopy = top;
            bottom = back;
            top = front;
            front = bottomCopy;
            back = topCopy;
        }
    }
}
