package com.locationlabs.stuff.msft;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class RemoveElement {
   private static int removeElement(int[] nums, int val) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int count = 0;

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != val) {
            nums[count++] = nums[i];
         }
      }

      return count;
   }

   public static void main(String[] args) {
      int[] nums = {0,1,2,2,3,0,4,2};
      System.out.println(removeElement(nums, 2));
      System.out.println(Arrays.toString(nums));

      nums = new int[] {3,2,2,3};
      System.out.println(removeElement(nums, 3));
      System.out.println(Arrays.toString(nums));
   }
}
