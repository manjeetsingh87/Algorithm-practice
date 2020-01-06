package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 7/19/19.
 */
public class FirstBadVersion {
   private static int firstBadVersion(int n) {
      if (n <= 0) {
         return -1;
      }

      int left = 0, right = n;

      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (isBadVersion(mid)) {
            right = mid;
         } else {
            left = mid + 1;
         }
      }
      return left;
   }

   private static boolean isBadVersion(int num) {
      return false;
   }
}
