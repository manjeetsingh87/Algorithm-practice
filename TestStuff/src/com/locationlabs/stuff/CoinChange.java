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

      int[] dp = new int[amount + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;

      for (int sum = 1; sum <= amount; sum++) {
         for (int coin : coins) {
            // if the current coin is more than sum,
            // or there was no possible way to make the remaining amount wwhen we're trying to use this coin.
            if (coin <= sum && dp[sum - coin] != Integer.MAX_VALUE) {
               dp[sum] = Math.min(dp[sum],
                       1 + dp[sum - coin]);
            }
         }
      }
      return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
   }

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
   }
}
