package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/9/20.
 */
public class ArrayPartitionI {
   private static int arrayPairSum(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      final int[] hash = new int[20001];
      for (int num : nums) {
         hash[num + 10000]++;
      }

      int sum = 0;
      boolean odd = true;

      for (int i = 0; i < 20001; i++) {
         if (hash[i] == 0) {
            continue;
         }

         while (hash[i] != 0) {
            if (odd) {
               sum += (i - 10000);
            }

            odd = !odd;
            hash[i]--;
         }
      }

      return sum;
   }

   public static void main(String[] args) {
      System.out.println(arrayPairSum(new int[]{1, 4, 2, 3}));
   }
}
