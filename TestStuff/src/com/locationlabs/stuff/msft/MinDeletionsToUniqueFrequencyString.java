package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class MinDeletionsToUniqueFrequencyString {
   private static int minDeletions(String S) {
      if (S == null || S.length() <= 1) {
         return 0;
      }

      final Map<Character, Integer> map = new HashMap<>();
      for (char ch : S.toCharArray()) {
         map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      System.out.println(map);

      final Set<Integer> frequencies = new HashSet<>();
      int minDeletions = 0;

      for (int frequency : map.values()) {
         if (!frequencies.contains(frequency)) {
            frequencies.add(frequency);
            continue;
         }

         int curr = frequency;
         while (curr > 0 && frequencies.contains(curr)) {
            curr--;
            minDeletions++;
         }

         if (curr > 0) {
            frequencies.add(curr);
         }
      }

      return minDeletions;
   }

   public static void main(String[] args) {
      System.out.println(minDeletions("eeeeffff"));
      System.out.println(minDeletions("aabbffddeaee"));
      System.out.println(minDeletions("llll"));
      System.out.println(minDeletions("example"));
   }
}
