package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class JewelsAndStones {
   private static int numJewelsInStones(String J, String S) {
      if (J == null || J.isEmpty()) {
         return 0;
      }

      if (S == null || S.isEmpty()) {
         return 0;
      }

      int stones = 0;
      final Map<Character, Integer> map = new HashMap<>();
      for (char jewel : J.toCharArray()) {
         map.put(jewel, map.getOrDefault(jewel, 0) + 1);
      }

      for (char stone : S.toCharArray()) {
         if (map.containsKey(stone)) {
            stones++;
         }
      }
      return stones;
   }

   public static void main(String[] args) {
      System.out.println(numJewelsInStones("aA", "aAAbbbb"));
      System.out.println(numJewelsInStones("z", "ZZ"));
   }
}
