package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1062 {

    static int N, K;
    static String [] word;
    static boolean [] arr = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println("0");
            return;
        }
        else if (K == 26) {
            System.out.println(N);
            return;
        }

        word = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            word[i] = str.substring(4,str.length()-4);
        }

        arr['a'-'a'] = true;
        arr['c'-'a'] = true;
        arr['i'-'a'] = true;
        arr['n'-'a'] = true;
        arr['t'-'a'] = true;

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int start, int depth) {

        if (depth == K-5) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean check = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!arr[word[i].charAt(j)-'a']) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!arr[i]) {
                arr[i] = true;
                dfs(i, depth+1);
                arr[i] = false;
            }
        }
    }
}
