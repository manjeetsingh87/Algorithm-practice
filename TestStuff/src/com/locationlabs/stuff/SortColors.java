package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class SortColors {
   private static void sortColors(int[] nums) {
      if (nums == null || nums.length == 0) {
         return;
      }

      int red = 0, blue = nums.length-1, index = 0;
      while (index <= blue) {
         if (nums[index] == 0) {
            int tmp = nums[red];
            nums[red++] = nums[index];
            nums[index++] = tmp;
         } else if (nums[index] == 2) {
            int tmp = nums[index];
            nums[index] = nums[blue];
            nums[blue--] = tmp;
         } else {
            index++;
         }
      }
      System.out.println(Arrays.toString(nums));
   }

   public static void main(String[] args) {
      sortColors(new int[]{2,0,2,1,1,0});
      sortColors(new int[]{1,2,0});
   }
}
