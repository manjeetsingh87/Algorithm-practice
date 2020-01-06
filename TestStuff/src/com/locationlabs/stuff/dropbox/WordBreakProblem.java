package com.locationlabs.stuff.dropbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class WordBreakProblem {
   private static boolean wordBreak(String s, List<String> wordDict) {
      if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
         return false;
      }

      final Set<String> wordSet = new HashSet<>(wordDict);
      final int len = s.length();
      final boolean dp[] = new boolean[len];
      for (int i = 0; i < len; i++) {
         for (int j = 0; j <= i; j++) {
            if ((j == 0 || dp[j - 1]) && wordSet.contains(s.substring(j, i + 1))) {
               dp[i] = true;
               break;
            }
         }
      }
      return dp[len - 1];
   }

   private static List<String> wordBreakII(String s, List<String> wordDict) {
      if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
         return new ArrayList<>();
      }

      final Map<String, List<String>> cache = new HashMap<>();
      return dfs(s, new HashSet<>(wordDict), cache);
   }

   private static List<String> dfs(String str, Set<String> wordSet, Map<String, List<String>> cache) {
      if (cache.containsKey(str)) {
         return cache.get(str);
      }

      final List<String> result = new ArrayList<>();
      if (wordSet.contains(str)) {
         result.add(str);
      }

      for (int i = 0; i < str.length(); i++) {
         final String left = str.substring(0, i);
         String right = str.substring(i);
         if (wordSet.contains(left) && containsSuffix(right, wordSet)) {
            for (String temp : dfs(right, wordSet, cache)) {
               result.add(left + " " + temp);
            }
         }
      }
      cache.put(str, result);
      return result;
   }

   private static boolean containsSuffix(String str, Set<String> wordSet) {
      for (int i = 0; i < str.length(); i++) {
         if (wordSet.contains(str.substring(i))) {
            return true;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
      System.out.println(wordBreakII("leetcode", Arrays.asList("leet", "code")));
      System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
      System.out.println(wordBreakII("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
      System.out.println(wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
      System.out.println(wordBreakII("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
   }
}
