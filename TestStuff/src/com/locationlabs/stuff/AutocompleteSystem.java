package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 10/3/19.
 */
public class AutocompleteSystem {
   private class TrieNode {
      private Map<Character, TrieNode> children;
      private Map<String, Integer> counts;
      private boolean isWord;

      private TrieNode() {
         children = new HashMap<>();
         counts = new HashMap<String, Integer>();
         isWord = false;
      }
   }

   private TrieNode root;
   private String prefix;

   public AutocompleteSystem(String[] sentences, int[] times) {
      root = new TrieNode();
      prefix = "";
      for (int i = 0; i < sentences.length; i++) {
         add(sentences[i], times[i]);
      }
   }

   public List<String> input(char c) {
      if (c == '#') {
         add(prefix, 1);
         prefix = "";
         return new ArrayList<>();
      }

      prefix = prefix + c;
      TrieNode curr = root;
      for (char ch : prefix.toCharArray()) {
         final TrieNode next = curr.children.get(ch);
         if (next == null) {
            return new ArrayList<>();
         }
         curr = next;
      }

      final PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((
              a, b) -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue()) : b.getValue().compareTo(a.getValue()));

      pq.addAll(curr.counts.entrySet());
      final List<String> result = new ArrayList<>();
      int k = 3;
      while (!pq.isEmpty() && k > 0) {
         result.add(pq.poll().getKey());
         k--;
      }
      return result;
   }

   private void add(String sentence, int count) {
      TrieNode curr = root;
      for (char ch : sentence.toCharArray()) {
         TrieNode next = curr.children.get(ch);
         if (next == null) {
            next = new TrieNode();
            curr.children.put(ch, next);
         }
         curr = next;
         curr.counts.put(sentence, curr.counts.getOrDefault(sentence, 0) + count);
      }
      curr.isWord = true;
   }

   public static void main(String[] args) {
      final AutocompleteSystem system = new AutocompleteSystem(
              new String[]{"i love you", "island","ironman", "i love leetcode"}, new int[]{5,3,2,2});
      System.out.println(system.input('i'));
      System.out.println(system.input(' '));
      System.out.println(system.input('a'));
      System.out.println(system.input('#'));
      System.out.println(system.input('i'));
      System.out.println(system.input(' '));
      System.out.println(system.input('a'));
      System.out.println(system.input('#'));
      System.out.println(system.input('i'));
      System.out.println(system.input(' '));
      System.out.println(system.input('a'));
      System.out.println(system.input('#'));
   }
}
