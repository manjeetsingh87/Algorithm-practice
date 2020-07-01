package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class LargestMAlignedSubSet {
   private static int largestMAligned(int[] nums, int M) {
      if (nums == null || nums.length < M) {
         return 0;
      }

      int max = 0;
      final Map<Integer, Integer> map = new HashMap<>();

      for (int num : nums) {
         int rem = num % M;

         if (rem < 0) {
            rem += M;
         }

         map.put(rem, map.getOrDefault(rem, 0) + 1);
      }

      for (int size : map.values()) {
         if (size >= M) {
            max = Math.max(max, size);
         }
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(largestMAligned(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
      System.out.println(largestMAligned(new int[]{4, 7, 10, 6, 9}, 3));
      System.out.println(largestMAligned(new int[]{1, 4}, 2));
   }
}
