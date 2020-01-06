package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/25/19.
 */
public class ValidTriangleNumber {
   private static int triangleNumber(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int count  = 0;
      Arrays.sort(nums);

      for (int i = nums.length - 1; i > 1; i--) {
         int left = 0, right = i -1;
         while (left < right) {
            if (nums[left] + nums[right] > nums[i]) {
               count += right - left;
               right--;
            } else {
               left++;
            }
         }
      }

      return count;
   }

   public static void main(String[] args) {
      System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
      System.out.println(triangleNumber(new int[]{0, 0, 0}));
   }
}
