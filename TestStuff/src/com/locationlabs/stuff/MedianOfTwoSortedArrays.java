package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/14/19.
 */
public class MedianOfTwoSortedArrays {
   private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
         return findMedianSortedArrays(nums2, nums1);
      }

      int len1 = nums1.length;
      int len2 = nums2.length;

      int start = 0;
      int end = len1;

      while (start <= end) {
         int partitionX = (start + end) / 2;
         int partitionY = (len1 + len2 + 1) / 2 - partitionX;

         int leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
         int rightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];

         int leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
         int rightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];

         if (leftX <= rightY && leftY <= rightX) {
            if ((len1 + len2) % 2 == 0) {
               return ((double)Math.max(leftX, leftY) + Math.min(rightX, rightY))/2;
            } else {
               return (double)Math.max(leftX, leftY);
            }
         } else if (leftX > rightY) {
            end = partitionX - 1;
         } else {
            start = partitionX + 1;
         }
      }

      return 0.0;
   }

   public static void main(String[] args) {
      /*System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
      System.out.println(findMedianSortedArrays(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 18, 19, 21, 25}));*/
      System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
   }
}
