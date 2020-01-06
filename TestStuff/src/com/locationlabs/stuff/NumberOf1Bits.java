package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class NumberOf1Bits {
   private static int hammingWeight(int n) {
      int count = 0;
      while (n != 0) {
         count++;
         n &= n - 1;
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(hammingWeight(00000000000000000000000000001011));
      System.out.println(hammingWeight(00000000000000000000000010000000));
   }
}
