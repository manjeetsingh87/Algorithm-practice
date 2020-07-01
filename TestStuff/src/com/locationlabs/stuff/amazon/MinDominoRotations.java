package com.locationlabs.stuff.amazon;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class MinDominoRotations {
   private static int minDominoRotations(int[] A, int[] B) {
      if (A == null || B == null || A.length != B.length) {
         return -1;
      }

      final int[] countA = new int[7]; // records the occurrence of i in A.
      final int[] countB = new int[7]; // records the occurrence of i in B.
      final int[] same = new int[7]; // records count of occurrence in both A and B.

      for (int i = 0; i < A.length; i++) {
         countA[A[i]]++;
         countB[B[i]]++;

         if (A[i] == B[i]) {
            same[A[i]]++;
         }
      }

      for (int i = 0; i < 7; i++) {
         if (countA[i] + countB[i] - same[i] >= A.length) {
            return Math.min(countA[i], countB[i]) - same[i];
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
      System.out.println(minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
   }
}
