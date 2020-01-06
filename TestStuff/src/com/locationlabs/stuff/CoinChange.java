package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/27/19.
 */
public class CoinChange {
   private static int coinChange(int[] coins, int amount) {
      if (amount <= 0) {
         return 0;
      }

      int[] minCoins = new int[amount + 1];
      Arrays.fill(minCoins, Integer.MAX_VALUE);
      minCoins[0] = 0;

      for (int sum = 1; sum <= amount; sum++) {
         for (int coin : coins) {
            // if the current coin is more than sum,
            // or there was no possible way to make the remaining amount wwhen we're trying to use this coin.
            if (coin <= sum && minCoins[sum - coin] != Integer.MAX_VALUE) {
               minCoins[sum] = Math.min(minCoins[sum],
                       1 + minCoins[sum - coin]);
            }
         }
      }
      return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
   }

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
   }
}
