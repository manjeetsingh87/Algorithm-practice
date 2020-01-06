package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class HouseRobber {
   private static int rob(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int prevMax = 0;
      int currMax = 0;

      for (int num : nums) {
         int temp = currMax;
         currMax = Math.max(prevMax + num, currMax);
         prevMax = temp;
      }

      return currMax;
   }

   private static int robDp(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int len = nums.length;
      int[] dp = new int[len + 1];
      dp[0] = 0;
      dp[1] = nums[0];
      for (int i = 1; i < nums.length; i++) {
         dp[i + 1] = Math.max(dp[i], dp[i-1] + nums[i]);
      }

      return dp[len];
   }

   public static void main(String[] args) {
      System.out.println(rob(new int[]{1,2,3,1}));
      System.out.println(robDp(new int[]{1,2,3,1}));
      System.out.println(rob(new int[]{2,7,9,3,1}));
      System.out.println(robDp(new int[]{2,7,9,3,1}));
   }
}
