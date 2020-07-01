package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/26/20.
 */
public class MissingElementInSortedArray {
   private static int missingElement(int[] nums, int k) {
      int left = 1, right = nums.length;
      int target = nums[0] + k;

      while (left < right) {
         final int mid = (right + left) / 2;
         if (nums[mid] <= target + mid - 1) {
            left = mid + 1;
         } else {
            right = mid;
         }
      }

      return target + left - 1;
   }

   public static void main(String[] args) {
      System.out.println(missingElement(new int[]{4, 7, 9, 10}, 1));
      System.out.println(missingElement(new int[]{4, 7, 9, 10}, 3));
      System.out.println(missingElement(new int[]{1, 2, 4}, 3));
   }
}
