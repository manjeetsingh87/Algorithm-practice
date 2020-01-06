package com.locationlabs.stuff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 12/28/18.
 */
public class RepeatedNTimes {

   public static void main(String[] args) {
      System.out.println(repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
      System.out.println(Long.MAX_VALUE);
   }

   public static int repeatedNTimes(int[] A) {
      final Set<Integer> set = new HashSet<>();
      for(int num : A) {
         if(!set.add(num)) {
            return num;
         }
      }
      return Integer.MIN_VALUE;
   }
}
