package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/12/20.
 */
public class DiceRollTargetSum {
   private static final int MOD = 1000000007;

   private static int numRollsToTarget(int d, int f, int target) {
      Integer[][] memo = new Integer[d + 1][target + 1];
      return helper(d, f, target, memo);
   }

   private static int helper(int d, int f, int target, Integer[][] memo) {
      if (d == 0 || target <= 0) {
         return d == target ? 1 : 0;
      }

      final String key = d + " " + target;
      if (memo[d][target] != null) {
         return memo[d][target];
      }

      memo[d][target] = 0;
      for (int i = 1; i <= f; i++) {
         if (target >= i) {
            memo[d][target] = (memo[d][target] + helper(d - 1, f, target - i, memo)) % MOD;
         }
      }

      return memo[d][target];
   }

   public static void main(String[] args) {
      System.out.println(numRollsToTarget(1, 6, 3));
      System.out.println(numRollsToTarget(2, 6, 7));
      System.out.println(numRollsToTarget(2, 5, 10));
      System.out.println(numRollsToTarget(1, 2, 3));
      System.out.println(numRollsToTarget(30, 30, 500));
   }
}
