package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/11/19.
 */
public class PartitionKEqualSumSubsets {
   private static boolean canPartitionKSubsets(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      int sum = Arrays.stream(nums).sum();

      if (sum % k != 0) {
         return false;
      }

      boolean[] isVisited = new boolean[nums.length];
      return backtrack(nums, k, 0, 0, sum/k, isVisited);
   }

   private static boolean backtrack(int[] nums, int k, int index, int currentSum, int targetSum, boolean[] isVisited) {
      if (k == 0) {
         return true;
      }

      if (currentSum > targetSum) {
         return false;
      }

      if (currentSum == targetSum) {
         return backtrack(nums, k-1, 0, 0, targetSum, isVisited);
      }

      for (int i = index; i < nums.length; i++) {
         if (isVisited[i]) {
            continue;
         }

         isVisited[i] = true;
         if (backtrack(nums, k, i+1, currentSum+nums[i], targetSum, isVisited)) {
            return true;
         }
         isVisited[i] = false;
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
      System.out.println(canPartitionKSubsets(new int[]{1, 5, 11, 5}, 2));
   }
}
