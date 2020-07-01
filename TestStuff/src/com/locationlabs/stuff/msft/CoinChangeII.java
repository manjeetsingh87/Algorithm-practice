package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class CoinChangeII {
   private static int change(int amount, int[] coins) {
      if (coins == null || coins.length == 0) {
         return 0;
      }

      int[] combinations = new int[amount + 1];
      combinations[0] = 1;
      for (int coin : coins) {
         for (int i = coin; i <= amount; i++) {
            combinations[i] += combinations[i - coin];
         }
      }
      return combinations[amount];
   }

   public static void main(String[] args) {
      System.out.println(change(5, new int[]{1, 2, 5}));
      System.out.println(change(3, new int[]{2}));
      System.out.println(change(10, new int[]{10}));
   }
}
