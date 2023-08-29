package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1120 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        int maxSame = 0;
        for (int i = 0; i < B.length - A.length + 1; i++) {
            int same = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == B[j + i]) {
                    same += 1;
                }
            }
            maxSame = Math.max(maxSame, same);
        }

        System.out.println(A.length - maxSame);
    }
}
