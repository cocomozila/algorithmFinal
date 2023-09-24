package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_9328 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static String[][] board;
    static StringTokenizer st;
    static boolean[] haveKey;
    static boolean[][] visit;
    static boolean[][] doorVisit;
    static int[] moveY = {0, 1, 0, -1};
    static int[] moveX = {1, 0, -1, 0};
    static int findDocCount = 0;
    static Map<Character, ArrayList<Door>> doors;

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            init();
            start();
            sb.append(findDocCount).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void start() {
        for (int i = 0; i < N; i++) {
            bfs(i, 0);
            bfs(i, M - 1);
        }
        for (int i = 0; i < M; i++) {
            bfs(0, i);
            bfs(N - 1, i);
        }
    }

    public static void bfs(int y, int x) {
        if (isWall(y, x) || isVisited(y, x)) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (isValid(poll.y, poll.x)) {
                char c = board[poll.y][poll.x].charAt(0);

                if (!isVisited(poll.y, poll.x) && isEmpty(poll.y, poll.x)) {
                    visit[poll.y][poll.x] = true;
                    for (int i = 0; i < 4; i++) {
                        queue.add(new Node(poll.y + moveY[i], poll.x + moveX[i]));
                    }

                } else if (!isVisited(poll.y, poll.x) && isKey(c)) {
                    addKey(c);
                    visit[poll.y][poll.x] = true;
                    for (int i = 0; i < 4; i++) {
                        queue.add(new Node(poll.y + moveY[i], poll.x + moveX[i]));
                    }
                    if (doors.containsKey(c)) {
                        for (Door door : doors.get(c)) {
                            bfs(door.y, door.x);
                        }
                    }

                } else if (!isVisited(poll.y, poll.x) && isDoc(c)) {
                    visit[poll.y][poll.x] = true;
                    addFindDocCount();
                    for (int i = 0; i < 4; i++) {
                        queue.add(new Node(poll.y + moveY[i], poll.x + moveX[i]));
                    }

                } else if (!isVisited(poll.y, poll.x) && isDoor(c)) {
                    if (isHaveKey(c)) {
                        visit[poll.y][poll.x] = true;
                        for (int i = 0; i < 4; i++) {
                            queue.add(new Node(poll.y + moveY[i], poll.x + moveX[i]));
                        }
                    } else {
                        if (!doorVisit[poll.y][poll.x]) {
                            if (doors.containsKey(Character.toLowerCase(c))) {
                                doors.get(Character.toLowerCase(c)).add(new Door(poll.y, poll.x, c));
                            } else {
                                doors.put(Character.toLowerCase(c), new ArrayList<>());
                                doors.get(Character.toLowerCase(c)).add(new Door(poll.y, poll.x, c));
                            }
                            doorVisit[poll.y][poll.x] = true;
                        }
                    }
                }
            }
        }
    }

    private static boolean isHaveKey(char c) {
        char key = Character.toLowerCase(c);
        return haveKey[key - 97];
    }

    private static void addFindDocCount() {
        findDocCount += 1;
    }

    private static boolean isWall(int y, int x) {
        return board[y][x].equals("*");
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    private static boolean isVisited(int y, int x) {
        return visit[y][x];
    }

    private static boolean isDoc(char c) {
        return c == '$';
    }

    private static boolean isKey(char c) {
        return Character.isLowerCase(c);
    }

    private static void addKey(char c) {
        haveKey[c - 97] = true;
    }

    private static boolean isDoor(char c) {
        return Character.isUpperCase(c);
    }

    private static boolean isEmpty(int y, int x) {
        return board[y][x].equals(".");
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visit = new boolean[N][M];
        doorVisit = new boolean[N][M];
        findDocCount = 0;
        initBoard();
        initHaveKey();
        initDoors();
    }

    private static void initDoors() {
        doors = new HashMap<>();
    }

    private static void initHaveKey() throws IOException {
        String readLine = br.readLine();
        haveKey = new boolean[26];
        if (readLine.equals("0")) {
            return;
        }
        for (int i = 0; i < readLine.length(); i++) {
            char c = readLine.charAt(i);
            addKey(c);
        }
    }

    private static void initBoard() throws IOException {
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = readLine.substring(j, j + 1);
            }
        }
    }

    static class Door {
        int y;
        int x;
        char doorName;

        public Door(int y, int x, char doorName) {
            this.y = y;
            this.x = x;
            this.doorName = doorName;
        }
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
