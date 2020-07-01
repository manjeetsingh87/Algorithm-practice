package com.locationlabs.stuff.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class SingleNumberII {
   private static int singleNumber(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      int seenOnce = 0, seenTwice = 0;

      for (int num : nums) {
         // first appearance:
         // add num to seen_once
         // don't add to seen_twice because of presence in seen_once

         // second appearance:
         // remove num from seen_once
         // add num to seen_twice

         // third appearance:
         // don't add to seen_once because of presence in seen_twice
         // remove num from seen_twice
         seenOnce = ~seenTwice & (seenOnce ^ num);
         seenTwice = ~seenOnce & (seenTwice ^ num);
      }

      return seenOnce;
   }

   private static int singleNumberOtherApproach(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      final Set<Long> set = new HashSet<>();
      long arraySum = 0;
      for (int num : nums) {
         set.add((long)num);
         arraySum += num;
      }

      long setSum = set.stream().reduce(0l, (a, b) -> a + b);

      // 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
      return (int) ((3 * setSum - arraySum) / 2);
   }

   public static void main(String[] args) {
      System.out.println(singleNumberOtherApproach(new int[]{2, 2, 3, 2}));
      System.out.println(singleNumberOtherApproach(new int[]{0, 1, 0, 1, 0, 1, 99}));
   }
}
