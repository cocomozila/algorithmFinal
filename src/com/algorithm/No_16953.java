package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_16953 {

    static long A, B;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        while (A != B) {
            if (A > B) {
                cnt = -1;
                break;
            }
            String str = String.valueOf(B);
            if (str.charAt(str.length()-1) != '1' && B % 2 != 0) {
                cnt = -1;
                break;
            }
            if (B % 2 == 0) {
                B = B/2;
            } else {
                str = str.substring(0, str.length()-1);
                B = Long.parseLong(str);
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}


