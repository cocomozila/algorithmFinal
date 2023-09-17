package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_3190 {

    static int[][] board;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] moveY = {0, 1, 0, -1};
    static final int[] moveX = {1, 0, -1, 0};
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int appleCount = Integer.parseInt(br.readLine());
        initApple(appleCount);

        int snakeDirectionCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Snake snake = new Snake(0, 0);
        int totalTime = 0;
        for (int i = 0; i < snakeDirectionCount + 1; i++) {
            if (i < snakeDirectionCount) {
                st = new StringTokenizer(br.readLine());
                int time = Integer.parseInt(st.nextToken());
                String direction = st.nextToken();

                boolean isDead = snake.receiveCommend(time - totalTime, direction);
                totalTime += time - totalTime;
                if (isDead) {
                    System.out.println(snake.timeCount);
                    return;
                }
            } else {
                boolean isDead = snake.receiveCommend(9999, "D");
                if (isDead) {
                    System.out.println(snake.timeCount);
                    return;
                }
            }
        }

    }

    static class SnakeTail {
        int beforeY;
        int beforeX;
        int y;
        int x;
        SnakeTail snakeTail;

        public SnakeTail(int y, int x) {
            this.y = y;
            this.x = x;
            board[y][x] = 2;
        }

        void move(int beforeY, int beforeX) {
            this.beforeY = this.y;
            this.beforeX = this.x;
            this.y = beforeY;
            this.x = beforeX;
            board[y][x] = 2;
            board[this.beforeY][this.beforeX] = 0;
            if (snakeTail != null) {
                snakeTail.move(this.beforeY, this.beforeX);
            }
        }

        void insertTail() {
            if (snakeTail == null) {
                snakeTail = new SnakeTail(beforeY, beforeX);
            } else {
                snakeTail.insertTail();
            }
        }
    }

    static class Snake {
        int y;
        int x;
        int direction = 0;
        SnakeTail snakeTail;
        int timeCount = 0;

        Snake(int y, int x) {
            this.y = y;
            this.x = x;
        }

        boolean receiveCommend(int time, String nextDirection) {
            for (int i = 0; i < time; i++) {
                timeCount += 1;
                int beforeY = y;
                int beforeX = x;
                headMove();
                if (!checkValid(y, x)) {
                    return true;
                }
                if (isTail(y, x)) {
                    return true;
                }
                tailMove(beforeY, beforeX);
                if (findApple(y, x)) {
                    insertTail(beforeY, beforeX);
                }
            }
            changeDirection(nextDirection);
            return false;
        }

        void headMove() {
            this.y = this.y + moveY[direction];
            this.x = this.x + moveX[direction];
        }

        void tailMove(int beforeY, int beforeX) {
            if (snakeTail != null) {
                snakeTail.move(beforeY, beforeX);
            }
        }

        void changeDirection(String direction) {
            if (direction.equals("D")) {
                this.direction += 1;
                if (this.direction == 4) {
                    this.direction = 0;
                }
            } else {
                this.direction -= 1;
                if (this.direction == -1) {
                    this.direction = 3;
                }
            }
        }

        boolean findApple(int y, int x) {
            return board[y][x] == 1;
        }

        void insertTail(int beforeY, int beforeX) {
            if (snakeTail == null) {
                this.snakeTail = new SnakeTail(beforeY, beforeX);
            } else {
                snakeTail.insertTail();
            }
        }

        boolean checkValid(int y, int x) {
            return y >= 0 && x >= 0 && y < N && x < N;
        }

        boolean isTail(int y, int x) {
            return board[y][x] == 2;
        }
    }

    private static void initApple(int appleCount) throws IOException {
        for (int i = 0; i < appleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y - 1][x - 1] = 1;
        }
    }
}
