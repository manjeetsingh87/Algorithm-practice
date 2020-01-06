package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class WildCardMatching {
   private static boolean isMatch(String s, String p) {
      if (s == null && p == null) {
         return true;
      }

      if (s == null || p == null) {
         return false;
      }

      char[] str = s.toCharArray();
      char[] pattern = p.toCharArray();
      int writeIndex = 0;
      boolean isFirst = true;

      //replace multiple * with one *
      //e.g a**b***c --> a*b*c
      for (int i = 0; i < pattern.length; i++) {
         if (pattern[i] == '*') {
            if (isFirst) {
               pattern[writeIndex++] = pattern[i];
               isFirst = false;
            }
         } else {
            pattern[writeIndex++] = pattern[i];
            isFirst = true;
         }
      }

      int sLen = str.length;
      final boolean[][] dp = new boolean[sLen + 1][writeIndex + 1];
      dp[0][0] = true;

      if (writeIndex > 0 && pattern[0] == '*') {
         dp[0][1] = true;
      }

      for (int i = 1; i <= sLen; i++) {
         for (int j = 1; j <= writeIndex; j++) {
            if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
               dp[i][j] = dp[i - 1][j - 1];
            } else if (pattern[j - 1] == '*') {
               dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
         }
      }

      return dp[sLen][writeIndex];
   }

   public static void main(String[] args) {
      System.out.println(isMatch("aa", "a"));
      System.out.println(isMatch("aa", "*"));
      System.out.println(isMatch("cb", "?a"));
      System.out.println(isMatch("adceb", "*a*b"));
      System.out.println(isMatch("acdcb", "a*c?b"));
   }
}
