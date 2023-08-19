package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**P4
 * 수 고르기
 *
 * 수열이 주어졌을 때, M을 수열의 모든 두 원소의 차이 중 가장 큰 값이라고 한다. m은 그 차이 중 가장 작은 값이라고 한다.
 * 크기가 N인 수열 V가 주어진다. 여기서 K개 수를 적절히 제거해서 M+m을 가능한 작게 만드는 프로그램을 작성하시오.
 */

public class No_3988 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Deque<Node> deque = new ArrayDeque<>();

        int max;
        int total = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            Node node = new Node(i, arr[i + 1] - arr[i]);
            if (!deque.isEmpty() && deque.peekFirst().index <= (i - N - K - 1)) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast().value > node.value) {
                deque.removeLast();
            }
            deque.addLast(node);

            if (i >= (N - K - 1)) {
                max = arr[i] - arr[i - (N - K - 1)];
                int peek = deque.peekFirst().value;
                total = Math.min(total, peek + max);
            }
        }

        System.out.print(total);
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int[] arr = new int[N];
//
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(arr);
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        int max = Integer.MAX_VALUE;
//        int min = Integer.MAX_VALUE;
//        int total = Integer.MAX_VALUE;
//
//        int sum = 0;
//        sum += arr[0];
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < arr.length; i++) {
//            if (i < arr.length - 1) {
//                queue.add(arr[i + 1] - arr[i]);
//                if (i >= (N - K) - 1) {
//                    int a = arr[i - (N - K - 1)];
//                    int b = arr[i - (N - K - 2)];
//                    System.out.println("remove 1 = " + a);
//                    System.out.println("remove 2 = " + b);
//                    System.out.println("remove queue = " + (b - a));
//                    queue.remove(b - a);
//                }
//
//                if (i >= (N - K) - 2) {
//                    System.out.println("index = " + i);
//                    System.out.println("queue size = "+queue.size());
//                    System.out.println(arr[i + 1] + " " + arr[i - (N - K - 2)]);
//                    max = Math.min(max, arr[i + 1] - arr[i - (N - K - 2)]);
//                    int peek = queue.peek();
//                    System.out.println("max = " + (arr[i + 1] - arr[i - (N - K - 2)]));
//                    System.out.println("peek = " + peek);
//                    total = Math.min(total, peek + max);
//                    System.out.println("total = " + total);
//                    System.out.println();
//                }
//            }
//        }
//
//        System.out.println();
//        System.out.println("total = " + total);
//    }
}
