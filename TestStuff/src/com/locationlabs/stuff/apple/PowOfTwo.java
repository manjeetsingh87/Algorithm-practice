package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class PowOfTwo {
   private static boolean isPowerOfTwo(int n) {
      if (n == 0) {
         return false;
      }

      long num = (long) n;

      return (num & -num) == num;
   }

   public static void main(String[] args) {
      System.out.println(isPowerOfTwo(1));
      System.out.println(isPowerOfTwo(4));
      System.out.println(isPowerOfTwo(16));
      System.out.println(isPowerOfTwo(22));
   }
}
