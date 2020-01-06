package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class DivideTwoIntegers {
   private static int divide(int dividend, int divisor) {
      long result = divideLong(dividend, divisor);
      return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
   }

   private static long divideLong(long dividend, long divisor) {
      boolean isNegative = dividend < 0 != divisor < 0;

      dividend = Math.abs(dividend);
      divisor = Math.abs(divisor);

      if (dividend == 0 || dividend < divisor) {
         return 0;
      }

      long repeatTimes = 1;
      long sum = divisor;
      while ((sum + sum) <= dividend) {
         sum += sum;
         repeatTimes += repeatTimes;
      }

      return isNegative ? -(repeatTimes + divideLong(dividend - sum, divisor))
              : (repeatTimes + divideLong(dividend - sum, divisor));
   }

   public static void main(String[] args) {
      System.out.println(divide(10, 3));
      System.out.println(divide(7, -3));
      System.out.println(divide(Integer.MIN_VALUE, -1));
   }
}
