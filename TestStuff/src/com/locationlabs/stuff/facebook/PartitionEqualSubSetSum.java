package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class PartitionEqualSubSetSum {
   private static boolean canPartition(int[] nums) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      int sum = Arrays.stream(nums).sum();

      if (sum % 2 != 0) {
         return false;
      }

      sum /= 2;
      boolean[] dp = new boolean[sum + 1];
      dp[0] = true;

      for (int num : nums) {
         for (int i = sum; i >= num; i--) {
            dp[i] = dp[i] || dp[i - num];
         }
      }

      return dp[sum];
   }

   private static boolean canPartitionBacktrack(int[] nums) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      int sum = Arrays.stream(nums).sum();

      if (sum % 2 != 0) {
         return false;
      }

      Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
      return backtrack(nums, sum / 2, 0, memo);
   }

   private static boolean backtrack(int[] nums, int target,
                                    int idx, Boolean[][] memo) {
      if (target == 0) {
         return true;
      }

      if (idx == nums.length || target < 0) {
         return false;
      }

      if (memo[idx][target] != null) {
         return memo[idx][target];
      }

      if (backtrack(nums, target - nums[idx], idx + 1, memo)
              || backtrack(nums, target, idx + 1, memo)) {
         return true;
      }

      memo[idx][target] = false;
      return false;
   }

   public static void main(String[] args) {
      System.out.println(canPartition(new int[]{1, 5, 11, 5}));
   }
}
