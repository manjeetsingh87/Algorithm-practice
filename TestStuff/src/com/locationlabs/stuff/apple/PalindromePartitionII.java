package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/28/20.
 */
public class PalindromePartitionII {
   private static int minCut(String s) {
      if (s == null || s.length() <= 1) {
         return 0;
      }

      final char[] sChars = s.toCharArray();
      final int len = sChars.length;
      final boolean[][] isPalindrome = new boolean[len][len];
      final int[] cuts = new int[len];

      for (int i = 0; i < len; i++) {
         cuts[i] = i;
         for (int j = 0; j <= i; j++) {
            if (sChars[j] == sChars[i] && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1])) {
               isPalindrome[j][i] = true;
               cuts[i] = j == 0 ? 0 : Math.min(cuts[i], cuts[j - 1] + 1);
            }
         }
      }

      return cuts[len - 1];
   }

   public static void main(String[] args) {
      System.out.println(minCut("abcbd"));
   }
}
