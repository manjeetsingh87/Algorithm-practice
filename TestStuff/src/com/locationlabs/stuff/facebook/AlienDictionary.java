package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/14/19.
 */
public class AlienDictionary {
   private static String alienOrder(String[] words) {
      if (words == null || words.length == 0) {
         return "";
      }

      final Map<Character, Set<Character>> map = new HashMap<>();
      final Map<Character, Integer> degree = new HashMap<>();

      for (String word : words) {
         for (char ch : word.toCharArray()) {
            degree.put(ch, 0);
         }
      }

      for (int i = 0; i < words.length - 1; i++) {
         final String word1 = words[i];
         final String word2 = words[i + 1];
         int len = Math.min(word1.length(), word2.length());
         for (int j = 0; j < len; j++) {
            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);
            if (ch1 != ch2) {
               final Set<Character> set = map.getOrDefault(ch1, new HashSet<>());
               if (!set.contains(ch2)) {
                  set.add(ch2);
                  map.put(ch1, set);
                  degree.put(ch2, degree.get(ch2) + 1);
                  break;
               }
            }

            if (j == word2.length() - 1 && word1.length() > word2.length()) {
               return "Empty";
            }
         }
      }

      final Queue<Character> queue = new LinkedList<>();
      for (char ch : degree.keySet()) {
         if (degree.get(ch) == 0) {
            queue.offer(ch);
         }
      }

      final StringBuilder result = new StringBuilder();
      while (!queue.isEmpty()) {
         char ch = queue.poll();
         result.append(ch);
         if (map.containsKey(ch)) {
            for (char ch2 : map.get(ch)) {
               degree.put(ch2, degree.get(ch2) - 1);
               if (degree.get(ch2) == 0) {
                  queue.offer(ch2);
               }
            }
         }
      }

      return result.length() != degree.size() ? "Empty" : result.toString();
   }

   public static void main(String[] args) {
      System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
      System.out.println(alienOrder(new String[]{"abc", "ab"}));
      System.out.println(alienOrder(new String[]{"z", "x"}));
      System.out.println(alienOrder(new String[]{"z", "x", "z"}));
   }
}
