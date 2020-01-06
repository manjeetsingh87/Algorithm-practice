package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class PivotIndex {
   private static int pivotIndex(int[] nums) {
      if (nums == null || nums.length == 0) {
         return -1;
      }

      int sum = 0, leftSum = 0;
      for (int num : nums) {
         sum += num;
      }

      for (int i = 0; i < nums.length; i++) {
         if (leftSum * 2 == sum - nums[i]) {
            return i;
         }
         leftSum += nums[i];
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
      System.out.println(pivotIndex(new int[]{1, 2, 3}));
   }
}
