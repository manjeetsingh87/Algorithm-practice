package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class PerfectSquares {
   private static int numSquares(int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
         }
      }

      System.out.println(Arrays.toString(dp));

      return dp[n];
   }

   public static void main(String[] args) {
      System.out.println(numSquares(12));
      //System.out.println(numSquares(13));
   }
}
