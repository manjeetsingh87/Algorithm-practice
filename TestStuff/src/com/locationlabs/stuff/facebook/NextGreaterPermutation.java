package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class NextGreaterPermutation {
   private static void nextPermutation(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return;
      }

      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i + 1]) {
         i--;
      }

      if (i <= 0) {
         System.out.println(-1);
         return;
      }

      if (i >= 0) {
         int j = nums.length - 1;
         while (nums[j] <= nums[i]) {
            j--;
         }
         swap(nums, i, j);
      }

      reverse(nums, i + 1, nums.length - 1);
      System.out.println(Arrays.toString(nums));
   }

   private static void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

   private static void reverse(int[] nums, int i, int j) {
      while (i < j) {
         swap(nums, i++, j--);
      }
   }

   public static void main(String[] args) {
      int[] nums = {1, 2, 3};
      nextPermutation(nums);

      nums = new int[]{3, 2, 1};
      nextPermutation(nums);

      nums = new int[]{1,2,5,4,3};
      nextPermutation(nums);
   }
}
