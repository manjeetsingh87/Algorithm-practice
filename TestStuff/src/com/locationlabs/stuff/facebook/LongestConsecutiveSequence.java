package com.locationlabs.stuff.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class LongestConsecutiveSequence {
   private static int longestConsecutive(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      final Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
      int best = 0;
      for (int num : set) {
         if (!set.contains(num - 1)) {
            int right = num + 1;
            while (set.contains(right)) {
               right += 1;
            }
            best = Math.max(best, right - num);
         }
      }
      return best;
   }

   public static void main(String[] args) {
      System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 2, 3}));
   }
}
