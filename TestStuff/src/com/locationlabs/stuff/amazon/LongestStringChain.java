package com.locationlabs.stuff.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class LongestStringChain {
   private static int longestStrChain(String[] words) {
      if (words == null || words.length <= 1) {
         return 0;
      }

      final Map<String, Integer> cache = new HashMap<>();
      for (String word : words) {
         cache.put(word, 0);
      }

      int max = 0;
      for (String word : words) {
         max = Math.max(helper(word, cache), max);
      }

      return max;
   }

   private static int helper(String word, Map<String, Integer> cache) {
      if (!cache.containsKey(word)) {
         return 0;
      }

      int result = cache.get(word);
      if (result > 0) {
         return result;
      }

      StringBuilder sb = new StringBuilder(word);
      int currMax = 0;
      for (int i = 0; i < word.length(); i++) {
         final char ch = sb.charAt(i);
         sb.deleteCharAt(i);
         currMax = Math.max(currMax, helper(sb.toString(), cache));
         sb.insert(i, ch);
      }

      cache.put(word, currMax + 1);
      return currMax + 1;
   }

   public static void main(String[] args) {
      System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
   }
}
