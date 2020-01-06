package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/4/19.
 */
public class WordBreak {
   private static boolean wordBreak(String s, List<String> wordDict) {
      if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
         return false;
      }

      final Set<String> wordSet = new HashSet<>(wordDict);
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;

      for (int i = 0; i <= s.length(); i++) {
         for (int j = 0; j < i; j++) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
               dp[i] = true;
               break;
            }
         }
      }
      return dp[s.length()];
   }

   public static void main(String[] args) {
//      System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
//      System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
      System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
   }
}
