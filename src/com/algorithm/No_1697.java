package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1697 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean[] check = new boolean[100001];

        if (K == 0) {
            System.out.println(N);
            return;
        }
        if (N > K) {
            System.out.println(N-K);
            return;
        }

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        que1.add(N);
        while (true) {
            while (!que2.isEmpty()) {
                que1.add(que2.poll());
            }
            while (!que1.isEmpty()) {
                int a = que1.poll();
                if (a == K) {
                    System.out.println(cnt);
                    return;
                }
                if (a - 1 >= 0 && a - 1 <= 100000 && !check[a - 1]) {
                    que2.add(a - 1);
                    check[a-1] = true;
                }
                if (a + 1 >= 0 && a + 1 <= 100000 && !check[a + 1]) {
                    que2.add(a + 1);
                    check[a+1] = true;
                }
                if (a * 2 >= 0 && a * 2 <= 100000 && !check[a * 2]) {
                    que2.add(a * 2);
                    check[a*2] = true;
                }
            }
            cnt++;
        }
    }
}
