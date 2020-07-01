package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/28/20.
 */
public class PalindromePartitionIII {
   private static int palindromePartition(String s, int K) {
      if (s == null || s.isEmpty() || K <= 0) {
         return 0;
      }

      final int len = s.length();
      final char[] sChars = s.toCharArray();
      int[][] toPal = new int[len][len];
      int[][] dp = new int[K + 1][len];

      for (int i = 0; i < len; i++) {
         toPal[i][i] = 0;
      }

      for (int i = len - 1; i >= 0; i--) {
         for (int j = i + 1; j < len; j++) {
            toPal[i][j] = getChanges(sChars, i, j);
         }
      }

      // k == 1 case
      for (int i = 0; i < s.length(); i++) {
         dp[1][i] = toPal[0][i];
      }

      // 2 <= K case
      for (int i = 2; i <= K; i++) {
         for (int end = i - 1; end < len; end++) {
            dp[i][end] = len;
            for (int start = end - 1; start >= 0; start--) {
               dp[i][end] = Math.min(dp[i][end], dp[i - 1][start] + toPal[start + 1][end]);
            }
         }
      }

      return dp[K][len - 1];
   }

   private static int getChanges(char[] sChars, int left, int right) {
      int changes = 0;

      while (left < right) {
         if (sChars[left++] != sChars[right--]) {
            changes++;
         }
      }

      return changes;
   }

   public static void main(String[] args) {
      System.out.println(palindromePartition("abc", 2));
      System.out.println(palindromePartition("aabbc", 3));
      System.out.println(palindromePartition("leetcode", 8));
   }
}
