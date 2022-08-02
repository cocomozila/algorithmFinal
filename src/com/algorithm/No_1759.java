package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1759 {

    static StringBuilder sb = new StringBuilder();
    static char[] pw;
    static char[] arr;
    static int L;
    static int C;
    static int cnt1 = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pw = new char[L];
        arr = new char[C];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {

        if (depth == L) {
            if (!check2()) {
                return;
            }
            for (int i = 0; i < L; i++) {
                sb.append(pw[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < C; i++) {
            if (check(i)) {
                pw[depth] = arr[i];
                dfs(depth+1);
                pw[depth] = '`';
            }
        }
    }

    public static boolean check(int a) {
        for (int i = 0; i < L; i++) {
            if (pw[i] >= arr[a]) {
                return false;
            }
        }
        return true;
    }

    public static boolean check2() {
        for (int i = 0; i < L; i++) {
            switch (pw[i]) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    cnt1++;
                    break;
                default:
                    cnt2++;
            }
        }
        if (cnt1 >= 1 && cnt2 >= 2) {
            cnt1 = 0;
            cnt2 = 0;
            return true;
        }
        cnt1 = 0;
        cnt2 = 0;
        return false;
    }
}
