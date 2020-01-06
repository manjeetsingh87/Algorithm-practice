package com.locationlabs.stuff.dropbox;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class SortedArraysMedian {
   private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
         return findMedianSortedArrays(nums2, nums1);
      }

      int len1 = nums1.length;
      int len2 = nums2.length;

      int low = 0;
      int high = len1;

      while (low <= high) {
         int partitionNums1 = (low + high) / 2;
         int partitionNums2 = (len1 + len2 + 1) / 2 - partitionNums1;

         int nums1LeftMax = (partitionNums1 == 0) ? Integer.MIN_VALUE
                 : nums1[partitionNums1 - 1];
         int nums1RightMin = (partitionNums1 == len1) ? Integer.MAX_VALUE
                 : nums1[partitionNums1];

         int nums2LeftMax = (partitionNums2 == 0) ? Integer.MIN_VALUE
                 : nums2[partitionNums2 - 1];
         int nums2RightMin = (partitionNums2 == len2) ? Integer.MAX_VALUE
                 : nums2[partitionNums2];

         if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
            if ((len1 + len2) % 2 == 0) {
               return (Math.max(nums1LeftMax, nums2LeftMax) +
                       Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } else {
               return Math.max(nums1LeftMax, nums2LeftMax);
            }
         } else if (nums1LeftMax > nums2RightMin) {
            high = partitionNums1 - 1;
         } else {
            low = partitionNums1 + 1;
         }
      }

      return 0.0;
   }

   public static void main(String[] args) {
      System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
      System.out.println(findMedianSortedArrays(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 18, 19, 21, 25}));
      System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
   }
}
