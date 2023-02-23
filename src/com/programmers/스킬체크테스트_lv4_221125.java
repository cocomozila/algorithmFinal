package com.programmers;

import java.util.HashMap;
import java.util.Map;

public class 스킬체크테스트_lv4_221125 {

    public static void main(String[] args) {
        스킬체크테스트_lv4_221125 lss = new 스킬체크테스트_lv4_221125();
        String[] arr = {"word","war","warrior","world","gone"};
        Trie trie = new Trie(new Node());
        System.out.println(lss.solution(arr));
    }

    public int solution(String[] words) {
        Trie trie = new Trie(new Node());
        int total = 0;
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            int sum = trie.add(word);
            total += sum;
        }
        return total;
    }

    static class Trie {

        Node root;

        public Trie(Node node) {
            this.root = node;
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node.childNode.computeIfAbsent(c, key -> new Node());
                node.count += 1;
                node = node.childNode.get(c);
            }
            node.childNode.computeIfAbsent('*', (e) -> new Node());
            node.count++;
        }

        public int add(String word) {
            Node node = root;
            int addCount = 0;
            for (int i = 0; i < word.length(); i++) {
                addCount += 1;
                if (node.count > 1) {
                    node = node.childNode.get(word.charAt(i));
                    continue;
                }
                return addCount-1;
            }
            return addCount;
        }
    }

    static class Node {

        Map<Character, Node> childNode;
        int count;

        public Node() {
            this.childNode = new HashMap<>();
        }
    }



}
