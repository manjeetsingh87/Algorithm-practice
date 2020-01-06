package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class SortedArraySquare {
   private static int[] sortedSquares(int[] A) {
      if (A == null || A.length == 0) {
         return A;
      }

      int len = A.length;
      final int[] result = new int[len];

      int i = 0, j = len - 1;
      for (int k = len - 1; k >= 0; k--) {
         if (Math.abs(A[i]) > Math.abs(A[j])) {
            result[k] = A[i] * A[i];
            i++;
         } else {
            result[k] = A[j] * A[j];
            j--;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
      System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
   }
}
