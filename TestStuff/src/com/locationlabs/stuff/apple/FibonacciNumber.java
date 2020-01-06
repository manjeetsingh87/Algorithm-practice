package com.locationlabs.stuff.apple;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/20/19.
 */
public class FibonacciNumber {
   private static int fib(int N) {
      if (N <= 1) {
         return N;
      }

      if (N == 2) {
         return 1;
      }

      int current = 0, first = 1, second = 1;
      for (int i = 3; i <= N; i++) {
         current = first + second;
         second = first;
         first = current;
      }
      return current;
   }

   private static int fibDp(int N) {
      if (N <= 1) {
         return N;
      }

      if (N == 2) {
         return 1;
      }

      int[] dp = new int[N + 1];
      Arrays.fill(dp, -1);
      dp[0] = 0;
      dp[1] = 1;
      memo(N, dp);
      return dp[N];
   }

   private static int memo(int n, int[] dp) {
      if (dp[n] != -1) {
         return dp[n];
      }

      dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
      return dp[n];
   }

   public static void main(String[] args) {
      System.out.println(fib(3));
      System.out.println(fibDp(3));
      System.out.println(fib(4));
      System.out.println(fibDp(4));
   }
}
