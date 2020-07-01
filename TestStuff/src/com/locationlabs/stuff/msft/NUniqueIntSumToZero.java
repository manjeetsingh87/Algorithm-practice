package com.locationlabs.stuff.msft;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class NUniqueIntSumToZero {
   private static int[] sumZero(int n) {
      if (n <= 1) {
         return new int[]{0};
      }

      int[] result = new int[n];
      int left = 0, right = n - 1, start = 1;

      while (left < right) {
         result[left++] = start;
         result[right--] = -start;
         start++;
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(sumZero(5)));
      System.out.println(Arrays.toString(sumZero(3)));
      System.out.println(Arrays.toString(sumZero(1)));
   }
}
