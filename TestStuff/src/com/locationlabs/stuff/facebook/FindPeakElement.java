package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class FindPeakElement {
   private static int findPeakElement(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      int left = 0, right = nums.length - 1;
      while (left < right) {
         int mid = (left + right) / 2;

         if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
         } else {
            right = mid;
         }
      }

      return left;
   }

   public static void main(String[] args) {
      System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
      System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
   }
}
