package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/10/19.
 */
public class DuplicateNumber {
   private static int findDuplicate(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      for (int i = 0; i < nums.length; i++) {
         nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
         if (nums[Math.abs(nums[i])] > 0) {
            return Math.abs(nums[i]);
         }
      }

      return 0;
   }

   private static int findDuplicateNum(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int slow = nums[0];
      int fast = nums[0];
      do  {
         slow = nums[slow];
         fast = nums[nums[fast]];
      } while (fast != slow);

      int first = nums[0];
      int second = slow;
      while (first != second) {
         first = nums[first];
         second = nums[second];
      }

      return second;
   }

   public static void main(String[] args) {
      //System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
      System.out.println(findDuplicateNum(new int[]{1, 3, 4, 2, 2}));
   }
}
