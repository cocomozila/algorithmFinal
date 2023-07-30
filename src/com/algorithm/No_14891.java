package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 톱니바퀴
 */

public class No_14891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SawtoothBoard sawtoothBoard = new SawtoothBoard();

        for (int i = 0; i < 4; i++) {
            Sawtooth sawtooth = new Sawtooth(br.readLine());
            sawtoothBoard.addSawtooth(i, sawtooth);
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            boolean rotate = Integer.parseInt(st.nextToken()) == 1;
            sawtoothBoard.move(index, rotate);
        }
        System.out.println(sawtoothBoard.getScore());
    }

    static class Sawtooth {
        int[] sawtooth = new int[8];

        public Sawtooth(String readLine) {
            for (int i = 0; i < readLine.length(); i++) {
                sawtooth[i] = Integer.parseInt(readLine.substring(i, i + 1));
            }
        }

        public void rotateClockwise(boolean rotate) {
            if (rotate) {
                int saveSawtooth = sawtooth[7];
                try {
                    for (int i = 7; i > 0; i--) {
                        sawtooth[i] = sawtooth[i - 1];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
                sawtooth[0] = saveSawtooth;
            } else {
                int saveSawtooth = sawtooth[0];
                try {
                    for (int i = 0; i < sawtooth.length; i++) {
                        sawtooth[i] = sawtooth[i + 1];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
                sawtooth[7] = saveSawtooth;
            }
        }

        public int getLeftSawtooth() {
            return sawtooth[6];
        }

        public int getRightSawtooth() {
            return sawtooth[2];
        }

        public boolean isTopEqualOne() {
            return sawtooth[0] == 1;
        }
    }

    static class SawtoothBoard {
        Sawtooth[] sawtooths = new Sawtooth[4];

        public void addSawtooth(int index, Sawtooth sawtooth) {
            sawtooths[index] = sawtooth;
        }

        public void move(int index, boolean rotate) {
            moveLeft(index, rotate);
            moveRight(index, rotate);
            sawtooths[index].rotateClockwise(rotate);
        }

        private void moveLeft(int index, boolean rotate) {
            if (isValidIndex(index - 1)) {
                if (sawtooths[index].getLeftSawtooth() != sawtooths[index - 1].getRightSawtooth()) {
                    moveLeft(index - 1, !rotate);
                    sawtooths[index - 1].rotateClockwise(!rotate);
                }
            }
        }

        private void moveRight(int index, boolean rotate) {
            if (isValidIndex(index + 1)) {
                if (sawtooths[index].getRightSawtooth() != sawtooths[index + 1].getLeftSawtooth()) {
                    moveRight(index + 1, !rotate);
                    sawtooths[index + 1].rotateClockwise(!rotate);
                }
            }
        }

        private boolean isValidIndex(int index) {
            return index >= 0 && index < 4;
        }

        public int getScore() {
            int score = 0;
            if (sawtooths[0].isTopEqualOne()) {
                score += 1;
            }
            if (sawtooths[1].isTopEqualOne()) {
                score += 2;
            }
            if (sawtooths[2].isTopEqualOne()) {
                score += 4;
            }
            if (sawtooths[3].isTopEqualOne()) {
                score += 8;
            }
            return score;
        }
    }
}
