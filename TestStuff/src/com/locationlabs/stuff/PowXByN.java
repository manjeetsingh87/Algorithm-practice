package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/25/19.
 */
public class PowXByN {
   private static double myPow(double x, int n) {
      long pow = n;

      if (pow < 0) {
         x = 1/x;
         pow = -pow;
      }

      double ans = 1, currentProd = x;

      for (long i = pow; i > 0; i /= 2) {
         if ((i % 2) == 1) {
            ans *= currentProd;
         }

         currentProd *= currentProd;
      }

      return ans;
   }

   public static void main(String[] args) {
      System.out.println(myPow(new Double(2), Integer.MIN_VALUE));
   }
}
