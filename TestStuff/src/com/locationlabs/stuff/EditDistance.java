package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class EditDistance {
   private static int minDistance(String word1, String word2) {
      if (word1 == null && word2 == null) {
         return 0;
      }

      int len1 = word1 == null ? 0 : word1.length();
      int len2 = word2 == null ? 0 : word2.length();

      // if one of the strings is empty;
      if (len1 * len2 == 0) {
         return len1 + len2;
      }

      int[][] editDistance = new int[len1+1][len2+1];

      for (int i = 0; i <= len1; i++) {
         editDistance[i][0] = i;
      }

      for (int i = 0; i <= len2; i++) {
         editDistance[0][i] = i;
      }

      for (int i = 1; i <= len1; i++) {
         for (int j = 1; j <= len2; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1)) {
               editDistance[i][j] = editDistance[i-1][j-1];
            } else {
               editDistance[i][j] = 1 + Math.min(Math.min(editDistance[i-1][j], editDistance[i][j-1]),
                                                 editDistance[i-1][j-1]);
            }
         }
      }
      return editDistance[len1][len2];
   }

   public static void main(String[] args) {
      System.out.println(minDistance("horse", "ros"));
      //System.out.println(minDistance("intention", "execution"));
   }
}
