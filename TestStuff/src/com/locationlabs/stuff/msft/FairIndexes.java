package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class FairIndexes {
   private static int fairIndexes(int[] A, int[] B) {
      if (A == null || B == null || A.length != B.length) {
         return 0;
      }

      int sumA = 0, sumB = 0;
      for (int i = 0; i < A.length; i++) {
         sumA += A[i];
         sumB += B[i];
      }

      if (sumA != sumB) {
         return 0;
      }


      int fairIndexes = 0;
      int currSumA = 0, currSumB = 0;
      for (int i = 0; i < A.length - 1; i++) {
         currSumA += A[i];
         currSumB += B[i];

         // Only need to check either sumA or sumB is twice of tmpA or tmpB
         if (sumA == 2 * currSumA && currSumA == currSumB) {
            fairIndexes++;
         }
      }

      return fairIndexes;
   }

   public static void main(String[] args) {
      System.out.println(fairIndexes(new int[]{4, -1, 0, 3}, new int[]{-2, 5, 0 ,3}));
      System.out.println(fairIndexes(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
      System.out.println(fairIndexes(new int[]{4, -1, 0, 3}, new int[]{-2, 6, 0, 4}));
      System.out.println(fairIndexes(new int[]{3, 2, 6}, new int[]{4, 1, 6}));
      System.out.println(fairIndexes(new int[]{1, 4, 2, -2, 5}, new int[]{7, -2, -2, 2, 5}));
   }
}
