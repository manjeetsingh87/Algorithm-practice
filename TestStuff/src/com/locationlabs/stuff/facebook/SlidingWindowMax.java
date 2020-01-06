package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class SlidingWindowMax {
   private static int[] maxSlidingWindow(int[] nums, int k) {
      // O(n) 2 pass, O(2n) space
      if(nums == null || nums.length == 0 || k == 0)
         return new int[0];

      int len = nums.length;
      int[] leftMax = new int[len];
      int[] rightMax = new int[len];

      leftMax[0] = nums[0];
      rightMax[len - 1] = nums[len - 1];

      for (int i = 1; i < len; i++) {
         leftMax[i] = (i % k == 0) ? nums[i] : Math.max(nums[i], leftMax[i - 1]);

         int right = len - 1 - i;
         rightMax[right] = (right % k == 0) ? nums[right] : Math.max(nums[right], rightMax[right + 1]);
      }

      final int[] slidingMax = new int[len - k + 1];
      for (int i = 0; i < len - k + 1; i++) {
         slidingMax[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
      }
      return slidingMax;
   }

   public static void main(String[] args) {
      int[] max = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
      System.out.println(Arrays.toString(max));
   }
}
