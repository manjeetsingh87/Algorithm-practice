package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 7/19/19.
 */
public class RotateArray {
   private static void rotate(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) {
         return;
      }

      int len = nums.length;
      k %= len;
      reverse(nums, 0, len - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, len - 1);
      System.out.println(Arrays.toString(nums));
   }

   private static void reverse(int[] nums, int start, int end) {
      while (start < end) {
         int tmp = nums[start];
         nums[start++] = nums[end];
         nums[end--] = tmp;
      }
   }

   public static void main(String[] args) {
      rotate(new int[]{1,2,3,4,5,6,7}, 3);
      rotate(new int[]{-1,-100,3,99}, 3);
   }
}
