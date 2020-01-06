package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class MaximumSwap {
   private static int maximumSwap(int num) {
      char[] digits = String.valueOf(num).toCharArray();

      int[] bucket = new int[10];
      for (int i = 0; i < digits.length; i++) {
         bucket[digits[i] - '0'] = i;
      }

      for (int i = 0; i < digits.length; i++) {
         for (int j = 9; j > digits[i] - '0'; j--) {
            if (bucket[j] > i) {
               char tmp = digits[i];
               digits[i] = digits[bucket[j]];
               digits[bucket[j]] = tmp;
               return Integer.valueOf(new String(digits));
            }
         }
      }

      return num;
   }

   public static void main(String[] args) {
      System.out.println(maximumSwap(2736));
      System.out.println(maximumSwap(9973));
   }
}
