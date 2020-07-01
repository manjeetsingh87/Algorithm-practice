package com.locationlabs.stuff.apple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/29/20.
 */
public class FindInMountainArray {
   interface MountainArray {
      int get(int index);
      int length();
   }

   private static final Map<Integer, Integer> map = new HashMap<>();

   private static int findInMountainArray(int target, MountainArray mountainArr) {
      if (mountainArr == null) {
         return -1;
      }

      // find peak element in mountain array
      final int len = mountainArr.length() - 1;
      final int peak = getPeakIndex(mountainArr, 0, len);

      // scan increasing order sub-array in the mountain array,
      // if element is found here, return the index
      int left = 0;
      int right = peak;
      while (left <= right) {
         final int mid = left + (right - left) / 2;
         final int val = get(mid, mountainArr);
         if (val < target) {
            left = mid + 1;
         } else if (target < val) {
            right = mid - 1;
         } else {
            return mid;
         }
      }

      // scan decreasing order sub-array in the mountain array,
      // if element is found here, return the index
      left = peak;
      right = len;
      while (left <= right) {
         final int mid = left + (right - left) / 2;
         final int val = get(mid, mountainArr);
         if (val < target) {
            right = mid - 1;
         } else if (target < val) {
            left = mid + 1;
         } else {
            return mid;
         }
      }

      // element not found
      return -1;
   }

   private static int get(int idx, MountainArray mountainArr) {
      if (!map.containsKey(idx)) {
         map.put(idx, mountainArr.get(idx));
      }

      return map.get(idx);
   }

   private static int getPeakIndex(MountainArray mountainArray, int left, int right) {
      while (left < right) {
         final int mid = left + (right - left) / 2;
         final int val = get(mid, mountainArray);

         if (val < get(mid + 1, mountainArray)) {
            left = mid + 1;
         } else {
            right = mid;
         }
      }

      return left;
   }
}
