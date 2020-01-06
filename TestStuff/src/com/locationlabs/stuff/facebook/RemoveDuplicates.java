package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 7/19/19.
 */
public class RemoveDuplicates {
   private static int removeDuplicates(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      if (nums.length == 1) {
         return 1;
      }

      int index = 0;
      for (int i = 1; i < nums.length; i++) {
         if (nums[index] != nums[i]) {
            index++;
            nums[index] = nums[i];
         }
      }
      System.out.println(Arrays.toString(Arrays.copyOf(nums, index + 1)));
      return index + 1;
   }

   public static void main(String[] args) {
      System.out.println(removeDuplicates(new int[]{1, 1, 2}));
      System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
   }
}
