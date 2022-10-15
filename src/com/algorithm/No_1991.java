package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1991 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node [] node = new Node[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            node[i] = new Node((char) ('A'+i));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char self = st.nextToken().charAt(0);
            char L = st.nextToken().charAt(0);
            if (L != '.') {
                node[self-'A'].left = node[L - 'A'];
            }
            char R = st.nextToken().charAt(0);
            if (R != '.') {
                node[self-'A'].right = node[R - 'A'];
            }
        }

        preOrder(node[0]);
        sb.append("\n");
        inOrder(node[0]);
        sb.append("\n");
        postOrder(node[0]);
        System.out.println(sb);
    }

    static class Node {
        char name;
        Node left;
        Node right;

        public Node(char node) {
            this.name = node;
        }
    }

    public static void preOrder(Node node) {
        sb.append(node.name);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        sb.append(node.name);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        sb.append(node.name);
    }
}
