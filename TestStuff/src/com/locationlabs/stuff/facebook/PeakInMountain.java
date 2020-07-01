package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class PeakInMountain {
   private static int peakIndexInMountainArray(int[] A) {
      if (A == null || A.length <= 1) {
         return -1;
      }

      int left = 0, right = A.length - 1;
      while (left < right) {
         final int mid = (left + right) / 2;
         if (A[mid] < A[mid + 1]) {
            left = mid + 1;
         } else {
            right = mid;
         }
      }

      return left;
   }

   public static void main(String[] args) {
      System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
      System.out.println(peakIndexInMountainArray(new int[]{0, 1, 2, 0}));
   }
}
