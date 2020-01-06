package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class CountDifferentPalindromeSubSequences {
   /**
    * The length of S will be in the range [1, 1000].
    * Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
    */
   private static int countPalindromicSubsequences(String S) {
      if (S == null || S.isEmpty()) {
         return 0;
      }

      int len = S.length();
      if (len == 1) {
         return 1;
      }

      int[][] dp = new int[len][len];
      char[] chars = S.toCharArray();
      long MOD = 1000000007;

      for (int i = len - 1; i >= 0; i--) {
         dp[i][i] = 1;
         for (int j = i + 1; j < len; j++) {
            if (chars[i] != chars[j]) {
               dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
            } else {
               int left = i + 1;
               int right = j - 1;
               while (left <= right && chars[i] != chars[left]) {
                  left++;
               }

               while (left <= right && chars[i] != chars[right]) {
                  right--;
               }

               if (left > right) {
                  dp[i][j] = 2 + dp[i + 1][j - 1] * 2;
               } else if (left == right) {
                  dp[i][j] = 1 + dp[i + 1][j - 1] * 2;
               } else {
                  dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
               }
            }
            dp[i][j] = (int) ((dp[i][j] + MOD) % MOD);
         }
      }

      return dp[0][len - 1];
   }

   public static void main(String[] args) {
      System.out.println(countPalindromicSubsequences("bccb"));
      System.out.println(countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
   }
}
