package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class CountingBits {
   private static int[] countBits(int num) {
      if (num <= 0) {
         return new int[1];
      }

      int[] result = new int[num + 1];
      result[1] = 1;

      int offset = 1;
      for (int i = 2; i <= num; i++) {
         if (i == offset * 2) {
            offset *= 2;
         }
         result[i] = result[i - offset] + 1;
      }
      return result;
   }

   public static void main(String[] args) {
      /*System.out.println(Arrays.toString(countBits(2)));
      System.out.println(Arrays.toString(countBits(3)));*/
      System.out.println(Arrays.toString(countBits(4)));
      /*System.out.println(Arrays.toString(countBits(5)));*/
   }
}
