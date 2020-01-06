package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class LongestIncreasingSubsequence {
   private static int lengthOfLISDP(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int result = 0;
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);

      for(int i = 0; i < nums.length; i++) {
         for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
               dp[i] = Math.max(dp[i], dp[j] + 1);
            }
         }
         result = Math.max(result, dp[i]);
      }

      return result;
   }

   private static int lengthOfLISBSearch(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int len = 0;
      int[] dp = new int[nums.length];

      for (int num : nums) {
         int idx = Arrays.binarySearch(dp, 0, len, num);
         if (idx < 0) {
            idx = -(idx + 1);
         }
         dp[idx] = num;
         if (idx == len) {
            len++;
         }
      }

      return len;
   }

   public static void main(String[] args) {
      System.out.println(lengthOfLISDP(new int[]{10,9,2,5,3,7,101,18}));
      System.out.println(lengthOfLISBSearch(new int[]{10,9,2,5,3,7,101,18}));
   }
}
