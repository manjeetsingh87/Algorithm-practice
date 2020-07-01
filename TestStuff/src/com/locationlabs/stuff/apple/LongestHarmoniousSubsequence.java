package com.locationlabs.stuff.apple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class LongestHarmoniousSubsequence {
   private static int findLHS(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      final Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      int result = 0;
      for (int key : map.keySet()) {
         if (map.containsKey(key + 1)) {
            result = Math.max(result, map.get(key) + map.get(key + 1));
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
   }
}
