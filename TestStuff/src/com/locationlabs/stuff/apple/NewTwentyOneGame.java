package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/22/20.
 */
public class NewTwentyOneGame {
   private static double new21Game(int N, int K, int W) {
      if (N <= 0 || K <= 0 || W <= 0) {
         return 1;
      }

      double[] dp = new double[N + W + 1];
      // dp[x] = the answer when Alice has x points
      for (int k = K; k <= N; k++) {
         dp[k] = 1.0;
      }

      double score = Math.min(N - K + 1, W);
      // S = dp[k+1] + dp[k+2] + ... + dp[k+W]
      for (int i = K - 1; i >= 0; i--) {
         dp[i] = score / W;
         score += dp[i] - dp[i + W];
      }
      return dp[0];
   }

   public static void main(String[] args) {
      System.out.println(new21Game(10, 1, 10));
      System.out.println(new21Game(6, 1, 10));
      System.out.println(new21Game(21, 17, 10));
   }
}