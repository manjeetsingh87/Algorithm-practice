package com.locationlabs.stuff;

import java.util.stream.IntStream;

/**
 * Created by manjeet.singh on 5/28/19.
 */
public class MissingNumber {
   private static int missingNumber(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int elements = nums.length;
      int totalSum = elements * (elements + 1)/2;

      int currentSum = IntStream.of(nums).sum();
      return totalSum - currentSum;
   }

   public static void main(String[] args) {
      System.out.println(missingNumber(new int[]{3, 0, 1}));
   }
}
