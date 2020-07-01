package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class RegExMatching {
   private static boolean isMatch(String s, String p) {
      if (s == null && p == null) {
         return true;
      }

      if (s.isEmpty() || p.isEmpty()) {
         return false;
      }

      int sLen = s.length(), pLen = p.length();
      final boolean[][] dp = new boolean[sLen + 1][pLen + 1];
      dp[0][0] = true;

      for (int i = 1; i <= pLen; i++) {
         if (p.charAt(i - 1) == '*') {
            dp[0][i] = dp[0][i - 2];
         }
      }

      for (int i = 1 ; i <= sLen; i++) {
         for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '.' || (p.charAt(j - 1) == s.charAt(i - 1))) {
               dp[i][j] = dp[i - 1][j - 1];
            } else if (p.charAt(j - 1) == '*') {
               if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                  dp[i][j] = dp[i][j - 2];
               } else {
                  dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
               }
            }
         }
      }

      return dp[sLen][pLen];
   }

   public static void main(String[] args) {
      System.out.println(isMatch("aab", "c*a*b"));
      System.out.println(isMatch("a", "a*"));
      /*System.out.println(isMatch("aa", "a"));
      System.out.println(isMatch("aa", "a*"));
      System.out.println(isMatch("ab", ".*"));
      System.out.println(isMatch("mississippi", "mis*is*p*."));
      System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));*/
   }
}
