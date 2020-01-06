package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class ValidPerfectSquare {
   private static boolean isPerfectSquare(int num) {
      if (num <= 0) {
         return false;
      }

      long number = (long)num;
      long left = 0, right = number;
      while (left <= right) {
         long mid = (left + right) / 2;
         if (mid * mid == number) {
            return true;
         }

         if (mid * mid < number) {
            left = mid + 1;
         } else {
            right = mid - 1;
         }
      }

      return false;
   }

   public static void main(String[] args) {
      System.out.println(isPerfectSquare(4));
      System.out.println(isPerfectSquare(15));
      System.out.println(isPerfectSquare(16));
      System.out.println(isPerfectSquare(99));
   }
}
