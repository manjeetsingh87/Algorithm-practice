package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class NumbersWithEqualDigitSum {
   private static int maxEqualDigitSum(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      final Map<Integer, Integer> map = new HashMap<>();
      int max = -1;

      for (int num : nums) {
         final int currDigitsSum = sumDigits(num);
         final Integer val = map.getOrDefault(currDigitsSum, null);
         if (val == null) {
            map.put(currDigitsSum, num);
            continue;
         }

         max = Math.max(max, num + val);
         if (num > val) {
            map.put(currDigitsSum, num);
         }
      }

      return max;
   }

   private static int sumDigits(int num) {
      int sum = 0;

      while (num > 0) {
         sum += num % 10;
         num /= 10;
      }

      return sum;
   }

   public static void main(String[] args) {
      System.out.println(maxEqualDigitSum(new int[]{51, 71, 17, 42}));
      System.out.println(maxEqualDigitSum(new int[]{42, 33, 60}));
      System.out.println(maxEqualDigitSum(new int[]{51, 32, 43}));
   }
}
