package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class PlusOne {
   private static int[] plusOne(int[] digits) {
      if (digits == null || digits.length == 0) {
         return digits;
      }

      int n = digits.length;
      for (int i = n - 1; i >= 0; i--) {
         if (digits[i] < 9) {
            digits[i]++;
            return digits;
         }
         digits[i] = 0;
      }

      int[] result = new int[n + 1];
      result[0] = 1;
      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
      System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
      System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
   }
}
