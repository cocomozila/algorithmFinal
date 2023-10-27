package com.programmers;

import java.util.StringTokenizer;

public class lv_1_공원산책 {

    static String[][] map;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {-1, 1, 0, 0};
    static int startX;
    static int startY;
    static int checkX;
    static int checkY;
    private static final int NORTH = 0;
    private static final int SOUTH = 1;
    private static final int EAST = 2;
    private static final int WEST = 3;

    public static void main(String[] args) {
        lv_1_공원산책 a = new lv_1_공원산책();
        String[] str = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int[] answer = a.solution(str, routes);
        System.out.println(answer[0]+", "+answer[1]);

    }

    public int[] solution(String[] park, String[] routes) {

        map = new String[park[0].length()][park.length];
        createMap(park);

        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            String count = st.nextToken();
            if (isValidMove(direction, count)) {
                for (int j = 0; j < Integer.parseInt(count); j++) {
                    moveStart(direction);
                }
            } else {
                checkX = startX;
                checkY = startY;
            }
            System.out.println("startX = " + startX);
            System.out.println("startY = " + startY);
        }

        int[] answer = {startY, startX};
        return answer;
    }

    private void moveStart(String direction) {
        if (direction.equals("N")) {
            startX += moveX[NORTH];
            startY += moveY[NORTH];
        } else if (direction.equals("S")) {
            startX += moveX[SOUTH];
            startY += moveY[SOUTH];
        } else if (direction.equals("E")) {
            startX += moveX[EAST];
            startY += moveY[EAST];
        } else {
            startX += moveX[WEST];
            startY += moveY[WEST];
        }
    }

    private void createMap(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].substring(j,j+1);
                if (map[i][j].equals("S")) {
                    startX = j;
                    startY = i;
                    checkX = j;
                    checkY = i;
                }
            }
        }
    }

    private boolean isValidMove(String direction, String moveCount) {
        int count = Integer.parseInt(moveCount);
        for (int i = 0; i < count; i++) {
            move(direction);
            if (checkX >= map[0].length || checkY >= map.length) {
                return false;
            }
            if (checkX < 0 || checkY < 0) {
                return false;
            }
            if (map[checkY][checkX].equals("X")) {
                return false;
            }
        }
        return true;
    }

    private void move(String direction) {
        if (direction.equals("N")) {
            checkX += moveX[NORTH];
            checkY += moveY[NORTH];
        } else if (direction.equals("S")) {
            checkX += moveX[SOUTH];
            checkY += moveY[SOUTH];
        } else if (direction.equals("E")) {
            checkX += moveX[EAST];
            checkY += moveY[EAST];
        } else {
            checkX += moveX[WEST];
            checkY += moveY[WEST];
        }
    }

}
