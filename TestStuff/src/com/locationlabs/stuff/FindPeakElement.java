package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/24/19.
 */
public class FindPeakElement {
   private static int findPeakElement(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int left = 0, right = nums.length-1;
      while (left < right) {
         int mid = (left + right) / 2;
         if (nums[mid] > nums[mid + 1]) {
            right = mid;
         } else {
            left = mid + 1;
         }
      }
      return left;
   }

   public static void main(String[] args) {
      //System.out.println(findPeakElement(new int[]{1,2,3,1}));
      System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
   }
}
