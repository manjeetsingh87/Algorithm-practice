package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class FirstMissingPositive {
   private static int firstMissingPositive(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int n = nums.length;

      // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
      // (we can ignore those because if all number are > n then we'll simply return 1)
      for (int i = 0; i < n; i++) {
         if (nums[i] <= 0 || nums[i] > n) {
            nums[i] = n + 1;
         }
      }

      // 2. mark each cell appearing in the array, by converting the index for that number to negative
      for (int i = 0; i < n; i++) {
         int num = Math.abs(nums[i]);
         if (num > n) {
            continue;
         }
         num--; // -1 for zero index based array (so the number 1 will be at pos 0)
         if (nums[num] > 0) {
            nums[num] = -1 * nums[num];
         }
      }

      for (int i = 0; i < n; i++) {
         if (nums[i] > 0) {
            return i + 1;
         }
      }

      return n + 1;
   }

   public static void main(String[] args) {
      System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
      System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
      System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
   }
}
