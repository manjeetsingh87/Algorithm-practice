package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/12/20.
 */
public class MinCostForTickets {
   private static int minCostTickets(int[] days, int[] costs) {
      if (days == null || days.length == 0 || costs == null || costs.length == 0) {
         return 0;
      }

      final int lastDay = days[days.length - 1];

      int[] dp = new int[lastDay + 1];
      boolean[] isTravelDay = new boolean[lastDay + 1];

      // mark the days we will be travelling
      for (int day : days) {
         isTravelDay[day] = true;
      }

      for (int i = 1; i <= lastDay; i++) {
         if (!isTravelDay[i]) {
            dp[i] = dp[i - 1];
            continue;
         }

         dp[i] = dp[i - 1] + costs[0]; // if we buy one day ticket for the current day

         dp[i] = Math.min(costs[1] + dp[Math.max(0, i - 7)], dp[i]); // compare with 7 day cost
         dp[i] = Math.min(costs[2] + dp[Math.max(0, i - 30)], dp[i]); // compare with 30 day cost
      }

      return dp[lastDay];
   }

   public static void main(String[] args) {
      System.out.println(minCostTickets(new int[]{1,4,6,7,8,20}, new int[]{2, 7, 15}));
      System.out.println(minCostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
   }
}
