package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/25/19.
 */
public class LongestPalindromeSubsequence {
   private static int longestPalindromeSubseq(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      int len = s.length();

      int[][] lcp = new int[len][len];

      for (int i = len - 1; i >= 0; i--) {
         lcp[i][i] = 1;
         for (int j = i + 1; j < len; j++) {
            if (s.charAt(i) == s.charAt(j)) {
               lcp[i][j] = lcp[i+1][j-1] + 2;
            } else {
               lcp[i][j] = Math.max(lcp[i+1][j], lcp[i][j-1]);
            }
         }
      }

      return lcp[0][len-1];
   }

   public static void main(String[] args) {
      System.out.println(longestPalindromeSubseq("bbbab"));
   }
}
