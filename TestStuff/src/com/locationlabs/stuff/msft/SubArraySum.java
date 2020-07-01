package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/10/20.
 */
public class SubArraySum {
   private static int minSubArrayLen(int s, int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      final int len = nums.length;
      int left = 0, right = 0, minLen = Integer.MAX_VALUE;
      int sum = 0;
      while (right < len) {
         sum += nums[right++];

         while (sum >= s) {
            minLen = Math.min(minLen, right - left);
            sum -= nums[left++];
         }
      }

      return minLen == Integer.MAX_VALUE ? 0 : minLen;
   }

   private static int maxSubArrayLen(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int maxLen = 0;
      final Map<Integer, Integer> map = new HashMap<>();
      int sum = 0;

      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];

         if (sum == k) {
            maxLen = i + 1;
         } else if (map.containsKey(sum - k)) {
            maxLen = Math.max(maxLen, i - map.get(sum - k) );
         }

         map.putIfAbsent(sum, i);
      }

      return maxLen;
   }

   public static void main(String[] args) {
      //System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

      System.out.println(maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
      System.out.println(maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
      System.out.println(maxSubArrayLen(new int[]{-1}, -1));
   }
}
