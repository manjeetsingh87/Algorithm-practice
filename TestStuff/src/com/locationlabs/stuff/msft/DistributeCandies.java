package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class DistributeCandies {
   private static int distributeCandies(int[] candies) {
      if (candies == null || candies.length == 0) {
         return 0;
      }

      final Set<Integer> set = Arrays.stream(candies).boxed().collect(Collectors.toSet());
      return Math.min(set.size(), candies.length / 2);
   }

   public static void main(String[] args) {
      System.out.println(distributeCandies(new int[]{1,1,2,2,3,3}));
      System.out.println(distributeCandies(new int[]{1,1,2,3}));
   }
}
