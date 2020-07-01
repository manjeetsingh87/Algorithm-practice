package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class LongestTurbulentSubarray {
   private static int maxTurbulenceSize(int[] A) {
      if (A == null || A.length == 0) {
         return 0;
      }

      final int len = A.length;
      int maxTurbulence = 1;
      int left = 0;

      for (int right = 1; right < len; right++) {
         final int cmp = Integer.compare(A[right - 1], A[right]);
         if (cmp == 0) {
            left = right;
         } else if (right == len - 1 || cmp * Integer.compare(A[right], A[right + 1]) != -1){
            maxTurbulence = Math.max(maxTurbulence, right - left + 1);
            left = right;
         }

      }

      return maxTurbulence;
   }

   public static void main(String[] args) {
      System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
      System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
      System.out.println(maxTurbulenceSize(new int[]{100}));
   }
}
