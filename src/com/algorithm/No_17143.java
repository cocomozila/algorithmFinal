package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class No_17143 {

    static int N;
    static int M;
    static int sharkCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharkCount = Integer.parseInt(st.nextToken());

        Sea sea = new Sea(N, M);

        for (int i = 0; i < sharkCount; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            sea.addShark(i, r - 1, c - 1, speed, direction, size);
        }

        for (int i = 0; i < M; i++) {
            sea.goFishing();
        }
        System.out.println(sea.getAllSharkSize());
    }

    static class Sea {
        private ArrayList<Shark>[][] board;
        private Map<Integer, Shark> map;
        private int position = -1;
        private int allSharkSize = 0;

        public Sea(int n, int m) {
            this.board = new ArrayList[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = new ArrayList<>();
                }
            }
            this.map = new HashMap<>();
        }

        public int getAllSharkSize() {
            return this.allSharkSize;
        }

        public void addShark(int index, int r, int c, int speed, int direction, int size) {
            Shark shark = new Shark(index, r, c, speed, direction, size);
            board[r][c].add(shark);
            map.put(index, shark);
        }

        public void goFishing() {
            move();
            fishing(N);
            moveAllShark();
        }

        private void move() {
            position += 1;
        }

        private void fishing(int depth) {
            for (int i = 0; i < depth; i++) {
                if (!board[i][position].isEmpty()) {
                    allSharkSize += board[i][position].get(0).getSize();
                    map.remove(board[i][position].get(0).getIndex());
                    board[i][position].remove(0);
                    return;
                }
            }
        }

        public void moveAllShark() {
            for (int i = 0; i < sharkCount; i++) {
                if (map.containsKey(i)) {
                    Shark shark = map.get(i);
                    board[shark.getY()][shark.getX()].remove(0);
                    shark.moveShark();
                    board[shark.getY()][shark.getX()].add(shark);
                    map.put(i, shark);
                }
            }

            // 중복한 상어들 로얄럼블
            for (int i = 0; i < sharkCount; i++) {
                if (map.containsKey(i)) {
                    Shark shark = map.get(i);
                    int y = shark.getY();
                    int x = shark.getX();
                    if (board[y][x].size() > 1) {
                        Shark kingShark = board[y][x].stream()
                                .max(Shark::compareTo)
                                .orElseThrow(NoSuchElementException::new);

                        List<Shark> loserSharks = board[y][x].stream()
                                .filter(s -> kingShark.size > s.size)
                                .collect(Collectors.toList());

                        board[y][x].clear();
                        board[y][x].add(kingShark);

                        for (int j = 0; j < loserSharks.size(); j++) {
                            map.remove(loserSharks.get(j).getIndex());
                        }
                    }
                }
            }
        }

        private void printMap() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!board[i][j].isEmpty()) {
                        System.out.print("O ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static class Shark implements Comparable<Shark> {
        int y;
        int x;
        int index;
        int speed;
        int direction;
        int size;

        public Shark(int index, int y, int x, int speed, int direction, int size) {
            this.index = index;
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        public void moveShark() {
            for (int i = 0; i < speed; i++) {
                if (direction == 1) {
                    if (y == 0) {
                        direction = 2;
                        y += 1;
                        continue;
                    }
                    y -= 1;
                } else if (direction == 2) {
                    if (y == N - 1) {
                        direction = 1;
                        y -= 1;
                        continue;
                    }
                    y += 1;
                } else if (direction == 3) {
                    if (x == M - 1) {
                        direction = 4;
                        x -= 1;
                        continue;
                    }
                    x += 1;
                } else {
                    if (x == 0) {
                        direction = 3;
                        x += 1;
                        continue;
                    }
                    x -= 1;
                }
            }
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getIndex() {
            return this.index;

        }
        public int getSize() {
            return this.size;
        }

        @Override
        public int compareTo(Shark o) {
            return this.size - o.size;
        }
    }
}
