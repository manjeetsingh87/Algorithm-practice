package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class ClimbingStairs {
   private static int climbStairs(int n) {
      if (n == 1) {
         return 1;
      }

      int first = 1, second = 2;
      for (int i = 3; i <= n; i++) {
         int third = first + second;
         first = second;
         second = third;
      }
      return second;
   }

   private static int climbStairsII(int n) {
      if (n == 1) {
         return 1;
      }

      int[] dp = new int[n+1];
      dp[1] = 1;
      dp[2] = 2;

      for (int i = 3; i <= n; i++) {
         dp[i] = dp[i-1] + dp[i-2];
      }

      return dp[n];
   }

   public static void main(String[] args) {
      System.out.println(climbStairs(3));
      System.out.println(climbStairsII(3));
   }
}
