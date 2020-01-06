package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 11/30/18.
 */
public class TwoSum {
   public static int[] twoSum(int[] nums, int target) {
      final Map<Integer, Integer> cache = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         final int otherNum = target-nums[i];
         if (cache.containsKey(otherNum)) {
            final int[] result = new int[]{i, cache.get(otherNum)};
            Arrays.sort(result);
            return result;
         }
         cache.put(nums[i], i);
      }
      return null;
   }

   private static int[] twoSumII(int[] nums, int target) {
      if (nums == null || nums.length < 2) {
         return null;
      }

      final Map<Integer, Integer> cache = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         final int currentNum = nums[i];
         final int otherNum = target - currentNum;
         Integer num = cache.getOrDefault(otherNum, null);
         if (num != null) {
            int[] result = new int[]{i, num};
            Arrays.sort(result);
            return result;
         }
         cache.put(currentNum, i);
      }
      return null;
   }

   private static int[] twoSumSorted(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return new int[2];
      }

      int start = 0, end = nums.length - 1;
      while (start <= end) {
         int sum = nums[start] + nums[end];
         if (sum == target) {
            return new int[]{start+1, end+1};
         } else if (sum < target) {
            start++;
         } else {
            end--;
         }
      }

      return new int[2];
   }

   public static void main(String[] args) {
//      int[] nums = {-3,4,3,90};
//      System.out.println(Arrays.toString(twoSum(nums, 0)));
//      System.out.println(Arrays.toString(twoSumII(nums, 0)));
//      System.out.println(Arrays.toString(twoSumII(new int[]{2,7,11,15}, 9)));
      System.out.println(Arrays.toString(twoSumSorted(new int[]{2,7,11,15}, 18)));
   }
}
