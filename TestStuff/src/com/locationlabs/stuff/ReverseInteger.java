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

   private static void sol(int N) {
      int enable_print = N % 10;
      while (N > 0) {
         if ((enable_print != 0) || (enable_print == 0 && N % 10 != 0)) {
            enable_print = 1;
         }

         if (enable_print == 1) {
            System.out.print(N % 10);
         }
         N = N / 10;
      }
   }

   public static void main(String[] args) {
      //System.out.println(reverse(-321));
      sol(12340);
      System.out.println("");
      sol(10011);
      System.out.println("");
      sol(54321);
      System.out.println("");
      sol(43108);
      System.out.println("");
      sol(100);
      System.out.println("");
      sol(9999);
   }
}
