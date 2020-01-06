package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class HammingDistance {
   private static int hammingDistance(int x, int y) {
      int xor = x ^ y, count = 0;
      while (xor != 0) {
         count += xor & 1;
         xor >>= 1;
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(hammingDistance(1, 4));
   }
}
