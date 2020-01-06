package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class SingleElementSortedArray {
   private static int singleNonDuplicate(int[] nums) {
      if (nums == null || nums.length == 0) {
         return Integer.MIN_VALUE;
      }

      int low = 0, high = nums.length - 1;
      while (low < high) {
         int mid = (low + high) / 2;

         if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
            return nums[mid];
         }

         if (mid % 2 == 0) {
            if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
               low = mid + 2;
            } else {
               high = mid;
            }
         } else {
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
               low = mid + 1;
            } else {
               high = mid - 1;
            }
         }
      }
      return nums[low];
   }

   public static void main(String[] args) {
      System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
      System.out.println(singleNonDuplicate(new int[]{1,2,2,3,3}));
      System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
      System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
   }
}
