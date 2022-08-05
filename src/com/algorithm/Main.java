package com.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
//   OX퀴즈

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String[] b = new String[a];
        String[] c = null;
        int cal = 1;
        int score = 0;

        for (int i = 0; i < a; i++) {
            b[i] = br.readLine();
        }

        for (int i = 0; i < a; i++) {
            cal = 1;
            for(int j = 0; j < b[i].length(); j++) {
                c = b[i].split("");
                if (j > 0) {
                    if (c[j].equals("O")) {
                        if (c[j-1].equals("O")) {
                            ++cal;
                            score += cal;
                        } else if (c[j-1].equals("X")) {
                            cal = 1;
                            score = score + cal;
                        }
                    }
                } else {
                    if (c[j].equals("O")) {
                        score = 1;
                    }
                }
            }

            System.out.println(score);
        }
        br.close();
    }

}
