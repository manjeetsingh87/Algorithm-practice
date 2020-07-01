package com.locationlabs.stuff.msft;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 4/3/20.
 */
public class LongestCommonSubsequence {
   private static int longestCommonSubsequence(String text1, String text2) {
      if ((text1 == null && text2 == null) || (text1.isEmpty() && text2.isEmpty())) {
         return 0;
      }

      if ((text1 == null || text2 == null) || (text1.isEmpty() || text2.isEmpty())) {
         return 0;
      }

      final int txt1Len = text1.length();
      final int txt2Len = text2.length();

      final int[][] dp = new int[txt1Len + 1][txt2Len + 1];

      for (int i = 0; i < txt1Len; i++) {
         for (int j = 0; j < txt2Len; j++) {
            if (text1.charAt(i) == text2.charAt(j)) {
               dp[i + 1][j + 1] = 1 + dp[i][j];
            } else {
               dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
         }
      }

      return dp[txt1Len][txt2Len];
   }

   public static void main(String[] args) {
      System.out.println(longestCommonSubsequence("abcde", "ace"));
      System.out.println(longestCommonSubsequence("abc", "abc"));
      System.out.println(longestCommonSubsequence("abc", "def"));
   }
}
