package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/16/19.
 */
public class SubarraySumEqualK {
   private static int subarraySum(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int count = 0, sum = 0;
      final Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
         }
         map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(subarraySum(new int[]{4,-1,-1}, 2));
      /*System.out.println(subarraySum(new int[]{1,2,3}, 3));*/
   }
}
