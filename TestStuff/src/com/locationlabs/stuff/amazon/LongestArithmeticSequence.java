package com.locationlabs.stuff.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/12/20.
 */
public class LongestArithmeticSequence {
   private static int longestArithSeqLength(int[] A) {
      if (A == null || A.length <= 1) {
         return 0;
      }

      int longest = 2;
      final int len = A.length;
      final Map<Integer, Integer>[] map = new HashMap[len];

      for (int i = 0; i < len; i++) {
         map[i] = new HashMap<>();
         for (int j = 0; j < i; j++) {
            final int diff = A[i] - A[j];
            map[i].put(diff, map[j].getOrDefault(diff, 1) + 1);
            longest = Math.max(longest, map[i].get(diff));
         }
      }

      return longest;
   }

   public static void main(String[] args) {
      System.out.println(longestArithSeqLength(new int[]{3, 6, 9, 12}));
      System.out.println(longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
      System.out.println(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
   }
}
