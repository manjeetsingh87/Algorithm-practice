package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/28/20.
 */
public class BinaryGap {
   private static int binaryGap(int N) {
      int max = 0;

      int start = -32;
      while (N > 0) {
         if (N % 2 == 1) {
            max = Math.max(max, start);
            start = 0;
         }

         N /= 2;
         start++;
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(binaryGap(22));
      System.out.println(binaryGap(5));
      System.out.println(binaryGap(6));
      System.out.println(binaryGap(8));
   }
}
