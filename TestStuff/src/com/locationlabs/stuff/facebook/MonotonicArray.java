package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class MonotonicArray {
   private static boolean isMonotonic(int[] A) {
      if (A == null || A.length <= 1) {
         return true;
      }

      boolean isDecreasingOrder = true;
      boolean isIncreasingOrder = true;
      for (int i = 1; i < A.length; i++) {
         if (A[i] > A[i - 1]) {
            isDecreasingOrder = false;
         } else if (A[i] < A[i - 1]) {
            isIncreasingOrder = false;
         }
      }
      return isDecreasingOrder || isIncreasingOrder;
   }

   public static void main(String[] args) {
      System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
      System.out.println(isMonotonic(new int[]{6,5,4,4}));
      System.out.println(isMonotonic(new int[]{1,3,2}));
   }
}
