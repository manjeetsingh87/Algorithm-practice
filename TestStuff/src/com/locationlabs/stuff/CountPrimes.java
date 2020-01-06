package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class CountPrimes {
   private static int countPrimes(int n) {
      if (n <= 1) {
         return 0;
      }

      boolean[] notPrime = new boolean[n];
      int count = 0;
      int boundary = (int)Math.sqrt(n);

      for (int i = 2; i <= boundary; i++) {
         if (!notPrime[i]) {
            int curr = i * i;
            while (curr < n) {
               notPrime[curr] = true;
               curr += i;
            }
            count++;
         }
      }

      for (int i = boundary + 1; i < n; i++) {
         if (!notPrime[i]) {
            count++;
         }
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(countPrimes(10));
   }
}
