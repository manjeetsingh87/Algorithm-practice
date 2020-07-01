package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class NRepatedInTwoNArray {
   private static int repeatedNTimes(int[] A) {
      if (A == null || A.length <= 1) {
         return 0;
      }

      for (int i = 2; i < A.length; i++) {
         if (A[i] == A[i - 1] || A[i - 2] == A[i]) {
            return A[i];
         }
      }

      return A[0];
   }

   public static void main(String[] args) {
      System.out.println(repeatedNTimes(new int[]{9, 5, 6, 9}));
      System.out.println(repeatedNTimes(new int[]{1, 2, 2, 3}));
      System.out.println(repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
      System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 4, 5}));
   }
}
