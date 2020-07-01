package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class MaxSumOfTwoNonOverlappingSubArrays {
   /**
    * Basically it can be broken it into 2 cases: L is always before M vs M is always before L.
    * L is always before M, we maintain a lMax to keep track of the max sum of L sub-array,
    * and sliding the window of M from left to right to cover all the M sub-array.
    * The same for the case where M is before L.
    */
   private static int maxSumTwoNoOverlap(int[] A, int L, int M) {
      if (A == null || A.length == 0 || L < 0 || M < 0) {
         return 0;
      }

      final int len = A.length;
      int[] preSum = new int[len];
      preSum[0] = A[0];
      for (int i = 1; i < len; i++) {
         preSum[i] = A[i] + preSum[i - 1];
      }

      int lMax = preSum[L - 1], mMax = preSum[M - 1];
      int result = preSum[L + M - 1];

      for (int i = L + M; i < len; i++) {
         //case 1: L sub-array is always before M sub-array
         lMax = Math.max(lMax, preSum[i - M] - preSum[i - L - M]);
         //case 2: M sub-array is always before L sub-array
         mMax = Math.max(mMax, preSum[i - L] - preSum[i - L - M]);
         //compare two cases and update result
         result = Math.max(result, Math.max(lMax + preSum[i] - preSum[i - M], mMax + preSum[i] - preSum[i - L]));
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
      System.out.println(maxSumTwoNoOverlap(new int[]{3,8,1,3,2,1,8,9,0}, 3, 2));
      System.out.println(maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
   }
}
