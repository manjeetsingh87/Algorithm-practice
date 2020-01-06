package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class IntegerBreak {
   /**
    * If an optimal product contains a factor f >= 4, then you can replace it with factors 2 and f-2 without losing optimality,
    * as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4,
    * meaning you only need factors 1, 2 and 3 (and 1 is of course wasteful and
    * you'd only use it for n=2 and n=3, where it's needed).
    * For the rest I agree, 3*3 is simply better than 2*2*2, so you'd never use 2 more than twice.
    */
   private static int integerBreak(int n) {
      if (n == 1) {
         return 1;
      }

      if (n == 2 || n == 3) {
         return n - 1;
      }

      int product = 1;
      while (n > 4) {
         product *= 3;
         n -= 3;
      }

      product *= n;
      return product;
   }

   public static void main(String[] args) {
      System.out.println(integerBreak(12));
      System.out.println(integerBreak(10));
   }
}
