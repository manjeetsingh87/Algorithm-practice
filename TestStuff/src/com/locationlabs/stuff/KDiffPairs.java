package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 6/4/19.
 */
public class KDiffPairs {
   private static int findPairs(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k < 0) {
         return 0;
      }

      final Map<Integer, Integer> map = new HashMap<>();
      int count = 0;
      for (int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if (k == 0) {
            if (entry.getValue() > 1) {
               count++;
            }
         } else {
            if (map.containsKey(entry.getKey() + k)) {
               count++;
            }
         }
      }

      return count;
   }

   public static void main(String[] args) {
      System.out.println(findPairs(new int[]{1, 3, 1, 5, 4, 3, 5}, 0));
      System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
      System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, -1));
   }
}
