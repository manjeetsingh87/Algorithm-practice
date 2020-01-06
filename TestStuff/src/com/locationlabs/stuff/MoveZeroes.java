package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/28/19.
 */
public class MoveZeroes {
   private static void moveZeroes(int[] nums) {
      if (nums == null || nums.length == 0) {
         return;
      }

      int indexPos = 0;
      for (int num : nums) {
         if (num != 0) {
            nums[indexPos++] = num;
         }
      }

      while (indexPos < nums.length) {
         nums[indexPos++] = 0;
      }

      System.out.println(Arrays.toString(nums));
   }

   public static void main(String[] args) {
      moveZeroes(new int[]{0,1,0,3,12});
      moveZeroes(new int[]{0,0,0,4,3,2,12});
   }
}
