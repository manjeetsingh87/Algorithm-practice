package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class LCIS {
   private static int findLengthOfLCIS(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int max = 1, maxSoFar = 1;
      for (int i = 0; i < nums.length - 1; i++) {
         if (nums[i] < nums[i + 1]) {
            maxSoFar++;
            max = Math.max(max, maxSoFar);
         } else {
            maxSoFar = 1;
         }
      }
      return max;
   }

   public static void main(String[] args) {
      System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
      System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
   }
}
