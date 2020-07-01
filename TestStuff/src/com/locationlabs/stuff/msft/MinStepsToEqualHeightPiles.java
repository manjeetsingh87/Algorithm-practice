package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class MinStepsToEqualHeightPiles {
   private static int minSteps(int[] nums) {
      if (nums == null || nums.length <= 1) {
         return 0;
      }

      Arrays.sort(nums);
      int steps = 0;
      int distinctNums = 0;
      int len = nums.length;

      for (int i = 1; i < len; i++) {
         if (nums[i - 1] != nums[i]) {
            distinctNums += 1;
         }

         steps += distinctNums;
      }

      return steps;
   }

   public static void main(String[] args) {
      System.out.println(minSteps(new int[]{5, 2, 1}));
      System.out.println(minSteps(new int[]{1, 2, 3, 4}));
   }
}
