package com.programmers;

public class lv_3_등굣길 {

    public static void main(String[] args) {
        lv_3_등굣길 a = new lv_3_등굣길();
        int[][] arr = {{2,2},{1,2}};
        int solution = a.solution(10, 10, arr);
        System.out.println(solution);
    }

    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[n][m];

        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        map[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    if (i != 0) {
                        map[i][j] += map[i - 1][j] % 1000000007;
                    }
                    if (j != 0) {
                        map[i][j] += map[i][j - 1] % 1000000007;
                    }
                } else {
                    map[i][j] = 0;
                }
            }
        }

        return map[n - 1][m - 1] % 1000000007;
    }
}
