package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class SmallestStringWithSwaps {
   /**
    * For each the given pairs, create connected groups using union-find.
    * Always mark the smaller index as parent
    * For each character in s, create mapping from root -> a list of candidate char.
    * Since we want to use the smallest one every time we pick from them, use PriorityQueue.
    * Finally, for each index, choose the first char in the associated pq and append into result.
    */
   private static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
      if (s == null || s.isEmpty()) {
         return null;
      }

      if (pairs == null || pairs.isEmpty()) {
         return s;
      }

      final int len = s.length();
      final int[] parent = new int[len];

      for (int i = 0; i < len; i++) {
         parent[i] = i;
      }

      for (List<Integer> p : pairs) {
         union(parent, p.get(0), p.get(1));
      }

      final char[] sChars = s.toCharArray();
      final Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
      for (int i = 0; i < len; i++) {
         int root = find(parent, i);
         parent[i] = root;
         map.putIfAbsent(root, new PriorityQueue<>());
         map.get(root).offer(sChars[i]);
      }

      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < len; i++) {
         sb.append(map.get(parent[i]).poll());
      }

      return sb.toString();
   }

   private static void union(int[] parent, int a, int b) {
      int aParent = find(parent, a);
      int bParent = find(parent,b);

      if (aParent < bParent) {
         parent[bParent] = aParent;
      } else {
         parent[aParent] = bParent;
      }
   }

   private static int find(int[] parent, int idx) {
      while (parent[idx] != idx) {
         parent[idx] = parent[parent[idx]];
         idx = parent[idx];
      }

      return idx;
   }

   public static void main(String[] args) {
      List<List<Integer>> pairs = new ArrayList<>();
      pairs.add(Arrays.asList(0, 3));
      pairs.add(Arrays.asList(1, 2));
      System.out.println(smallestStringWithSwaps("dcab", pairs));
   }
}
