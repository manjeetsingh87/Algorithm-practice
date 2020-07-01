package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class LargestNumXOccuringXTimes {
   private static int largestNum(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      final Map<Integer, Integer> map = new HashMap<>();
      int max = 0;

      for (int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if (entry.getKey().equals(entry.getValue())) {
            max = Math.max(max, entry.getKey());
         }
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(largestNum(new int[]{3, 8, 2, 3, 3, 2}));
      System.out.println(largestNum(new int[]{7, 1, 2, 8, 2}));
      System.out.println(largestNum(new int[]{3, 1, 4, 1, 5}));
      System.out.println(largestNum(new int[]{5, 5, 5, 5, 5}));
   }
}
