package com.locationlabs.stuff;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/21/19.
 */
public class MaxProductSubArray {
   private static int maxProduct(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int maxEndingHere = nums[0];
      int minEndingHere = nums[0];
      int maxSoFar = nums[0];

      for (int i = 1; i < nums.length; i++) {
         int temp = maxEndingHere;
         maxEndingHere = Math.max(Math.max(maxEndingHere * nums[i], minEndingHere * nums[i]), nums[i]);
         minEndingHere = Math.min(Math.min(temp * nums[i], minEndingHere * nums[i]), nums[i]);

         maxSoFar = Math.max(maxSoFar, maxEndingHere);
      }

      return maxSoFar;
   }

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2,3,-2,4}));
      System.out.println(maxProduct(new int[]{-4,-3,-2}));
   }
}
