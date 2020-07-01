package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 5/29/20.
 */
public class SearchInSortedArrayOfUnknownSize {
   interface ArrayReader {
      public int get(int index);
   }

   private static int search(ArrayReader reader, int target) {
      if (reader == null) {
         return -1;
      }

      if (reader.get(0) == target) {
         return 0;
      }

      int left = 0, right = 1;

      while (reader.get(right) <= target) {
         left = right;
         right *= 2;
      }

      while (left <= right) {
         final int mid = left + (right - left) / 2;
         final int curr = reader.get(mid);
         if (curr == target) {
            return mid;
         }

         if (curr < target) {
            left = mid + 1;
         } else {
            right = mid - 1;
         }
      }

      return -1;
   }
}
