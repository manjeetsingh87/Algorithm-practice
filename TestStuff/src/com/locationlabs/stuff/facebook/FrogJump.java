package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class FrogJump {
   private static boolean canCross(int[] stones) {
      if (stones == null || stones.length == 0) {
         return true;
      }

      final Map<Integer, Set<Integer>> map = new HashMap<>();
      map.put(0, new HashSet<>());
      map.get(0).add(1);
      for (int i = 1; i < stones.length; i++) {
         map.put(stones[i], new HashSet<>());
      }

      for (int i = 0; i < stones.length - 1; i++) {
         int stone = stones[i];
         for (int step : map.get(stone)) {
            int reach = step + stone;
            if (reach == stones[stones.length - 1]) {
               return true;
            }

            final Set<Integer> set = map.get(reach);
            if (set != null) {
               set.add(step);
               if (step > 0) {
                  set.add(step - 1);
               }
               set.add(step + 1);
            }
         }
      }

      return false;
   }

   public static void main(String[] args) {
      System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
      //System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));
   }
}
