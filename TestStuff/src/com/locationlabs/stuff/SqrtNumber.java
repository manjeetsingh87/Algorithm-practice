package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/25/19.
 */
public class SqrtNumber {
   private static double mySqrt(int x) {
      if (x == 0) {
         return 0;
      }

      float sqrt = x;

      while (sqrt*sqrt > x) {
         sqrt = (sqrt + x/sqrt) / 2.0f;
      }

      return (double) sqrt;
   }

   private static float sqrt(int x, int precision) {
      if (x == 0) {
         return 0;
      }

      int left = 0, right = x;
      double ans = 0;
      while (left <= right) {
         int mid = (left + right) / 2;
         if (mid <= x / mid) {
            left = mid + 1;
            ans = mid;
         } else {
            right = mid - 1;
         }
      }


      // For computing the fractional part
      // of square root upto given precision
      double increment = 0.1;
      for (int i = 0; i < precision; i++) {
         while (ans * ans <= x) {
            ans += increment;
         }

         // loop terminates when ans * ans > number
         ans = ans - increment;
         increment = increment / 10;
      }
      return (float)ans;
   }

   public static void main(String[] args) {
      /*System.out.println(sqrt(4));
      System.out.println(sqrt(5));*/
      System.out.println(sqrt(50, 2));
      System.out.println(sqrt(10, 5));
      /*System.out.println(sqrt(9));
      System.out.println(sqrt(16));*/
   }
}
