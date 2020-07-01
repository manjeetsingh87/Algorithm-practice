package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class GlobalLocalInversion {
   private static boolean isIdealPermutation(int[] A) {
      if (A == null || A.length == 0) {
         return true;
      }

      for (int i = 0; i < A.length; i++) {
         // Can only place i at A[i-1],A[i] or A[i+1].
         // check if all A[i] - i equals to -1, 0 or 1, in other words Math.abs(A[i] - i) should either 0 or 1
         // this means if Math.abs(A[i] - i) > 1, then there a point where local and global inversions are not same
         if (Math.abs(A[i] - i) > 1) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(isIdealPermutation(new int[]{1, 0, 2}));
      System.out.println(isIdealPermutation(new int[]{1, 2, 0}));
   }
}
