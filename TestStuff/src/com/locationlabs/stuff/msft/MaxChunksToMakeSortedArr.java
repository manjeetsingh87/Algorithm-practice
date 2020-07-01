package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/12/20.
 */
public class MaxChunksToMakeSortedArr {
   private static int maxChunksToSorted(int[] arr) {
      if (arr == null || arr.length == 0) {
         return 0;
      }

      int len = arr.length;
      if (len == 1) {
         return 1;
      }

      int chunks = 0, max = 0;
      for (int i = 0; i < len; i++) {
         max = Math.max(max, arr[i]);
         if (max == i) {
            chunks++;
         }
      }

      return chunks;
   }

   public static void main(String[] args) {
      System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
      System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
      System.out.println(maxChunksToSorted(new int[]{0}));
   }
}
