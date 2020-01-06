package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 8/22/19.
 */
public class MIssingNumberTwoSortedArrays {
   private static int missingNumber(int[] nums1, int[] nums2) {
      if (nums1 == null || nums2 == null) {
         return -1;
      }

      int len1 = nums1.length;
      int len2 = nums2.length;


      if (len1 < len2) {
         return missingNumber(nums2, nums1);
      }

      if (len1 != len2 + 1) {
         throw new IllegalArgumentException();
      }

      if (len2 == 0) {
         return nums1[0];
      }

      int start = 0, end = len1 - 1;
      while (start < end) {
         int mid = (start + end) / 2;
         if (nums1[mid] == nums2[mid]) {
            start = mid + 1;
         } else {
            end = mid;
         }
      }
      return nums1[start];
   }

   public static void main(String[] args) {
      int[] nums1 = {1, 2, 3, 8, 12, 16, 20};
      int[] nums2 = {1, 2, 3, 12, 16, 20};
      System.out.println(missingNumber(nums1, nums2));
   }
}
