package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class InterleavingStrings {
   private static boolean isInterleave(String s1, String s2, String s3) {
      if (s1.length() + s2.length() != s3.length()) {
         return false;
      }

      final int s1Len = s1.length();
      final int s2Len = s2.length();
      boolean[][] dp = new boolean[s2Len + 1][s1Len + 1];
      dp[0][0] = true;

      for (int i = 1; i < dp[0].length; i++) {
         dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
      }

      for (int i = 1; i < dp.length; i++) {
         dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
      }

      for (int i = 1; i < dp.length; i++) {
         for (int j = 1; j < dp[0].length; j++) {
            dp[i][j] = (dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                    || (dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
         }
      }

      return dp[s2Len][s1Len];
   }

   public static void main(String[] args) {
      System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
      System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
   }
}
