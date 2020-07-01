package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/1/20.
 */
public class SearchInsertPosition {
   private static int searchInsert(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int low = 0, high = nums.length - 1;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (nums[mid] == target) {
            return mid;
         }

         if (nums[mid] < target) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      return low;
   }

   public static void main(String[] args) {
      System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
      System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
      System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
      System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
   }
}
