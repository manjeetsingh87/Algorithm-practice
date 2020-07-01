package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class BinarySearch {
   private static int search(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return -1;
      }

      int low = 0, high = nums.length - 1;

      while (low <= high) {
         int mid =  (low + high) / 2;

         if (target == nums[mid]) {
            return mid;
         }

         if (target < nums[mid]) {
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
   }
}
