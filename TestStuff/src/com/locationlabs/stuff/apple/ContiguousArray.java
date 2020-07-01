package com.locationlabs.stuff.apple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/26/20.
 */
public class ContiguousArray {
   private static int findMaxLength(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      int maxLen = 0;
      int count = 0;

      final Map<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);
      for (int i = 0; i < nums.length; i++) {
         count += nums[i] == 1 ? 1 : -1;
         if (map.containsKey(count)) {
            maxLen = Math.max(maxLen, i - map.get(count));
         } else {
            map.put(count, i);
         }
      }

      return maxLen;
   }

   public static void main(String[] args) {
      System.out.println(findMaxLength(new int[]{0, 1, 0}));
   }
}
