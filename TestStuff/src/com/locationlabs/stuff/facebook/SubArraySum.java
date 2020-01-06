package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class SubArraySum {
   private static int subArraySum(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int count = 0, sum = 0;
      final Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      for (int num : nums) {
         sum += num;
         if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
         }
         map.put(sum, map.getOrDefault(sum, 0) + 1);
      }

      return count;
   }

   private static boolean checkSubarraySum(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      final Map<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);

      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (k != 0) {
            sum %= k;
         }
         if (map.containsKey(sum)) {
            if (i - map.get(sum) > 1) {
               return true;
            }
         } else {
            map.put(sum, i);
         }
      }

      return false;
   }

   public static void main(String[] args) {
      System.out.println(subArraySum(new int[]{1, 1, 1}, 2));
      System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
      System.out.println(checkSubarraySum(new int[]{0, 0}, 0));
   }
}
