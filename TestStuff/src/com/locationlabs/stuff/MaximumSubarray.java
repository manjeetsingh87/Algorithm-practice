package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 3/27/19.
 */
public class MaximumSubarray {

   private static int maxSubArray(int[] nums) {
      int max = nums[0], maxCurrent = nums[0];

      for (int i=1; i < nums.length; i++) {
         maxCurrent = Math.max(maxCurrent + nums[i], nums[i]);
         max = Math.max(max, maxCurrent);
      }
      return max;
   }

   public static void main(String[] args) {
      System.out.println(maxSubArray(new int[]{-1,-2,-4,-1,-3,-2}));
   }
}
