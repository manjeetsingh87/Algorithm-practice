package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/28/19.
 */
public class ReverseInteger {
   private static int reverse(int x) {
      int reversedInt = 0;

      while (x != 0) {
         try {
            reversedInt = Math.multiplyExact(reversedInt, 10);
            reversedInt = Math.addExact(reversedInt, x%10);
            x /= 10;
         } catch (ArithmeticException e) {
            return 0;
         }
      }

      return reversedInt;
   }

   public static void main(String[] args) {
      System.out.println(reverse(-321));
   }
}
