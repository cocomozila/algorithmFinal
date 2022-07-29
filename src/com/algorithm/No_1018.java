package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1018 {

    static char[][] whiteBoard;
    static char[][] blackBoard;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] array = new char[n][m];
        int whiteError = 0;
        int blackError = 0;
        int errorTotal = 64;

        createBoard();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for ( int j = 0; j < m; j++ ) {
                array[i][j] = str.charAt(j);
            }
        }
        for (int x = 0; x <= n-8; x++ ) {
            for (int y = 0; y <= m-8; y++) {
                // 탐색시작
                for (int i = 0+x; i < 8+x; i++) {
                    for (int j = 0+y; j < 8+y; j++) {
                        if (array[i][j] != whiteBoard[i-x][j-y]) {
                            whiteError += 1;
                        }
                        if (array[i][j] != blackBoard[i-x][j-y]) {
                            blackError += 1;
                        }
                    }
                }
                if ( whiteError <= blackError ) {
                    if ( whiteError < errorTotal ) {
                        errorTotal = whiteError;
                    }
                }
                else {
                    if ( blackError < errorTotal ) {
                        errorTotal = blackError;
                    }
                }
                whiteError = 0;
                blackError = 0;
            }
        }
        System.out.println(errorTotal);
    }

    public static void createBoard () {
        whiteBoard = new char[8][];
        blackBoard = new char[8][];

        for (int i = 0; i < 8; i++) {
            if ( i % 2 != 0 ) {
                blackBoard[i] = new char[]{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
                whiteBoard[i] = new char[]{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
                continue;
            }
            blackBoard[i] = new char[]{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
            whiteBoard[i] = new char[]{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
        }
    }
}
