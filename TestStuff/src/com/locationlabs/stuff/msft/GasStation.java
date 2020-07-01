package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/9/20.
 */
public class GasStation {
   private static final int EMPTY = 0;
   private static final int INVALID = -1;

   private static int canCompleteCircuit(int[] gas, int[] cost) {
      if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
         return INVALID;
      }

      int start = 0;
      int tank = EMPTY;
      int total = EMPTY;
      int count = gas.length;

      for (int station = 0; station < count; station++) {
         int fuel = gas[station] - cost[station];
         tank += fuel;
         total += fuel;

         if (tank < EMPTY) {
            tank = EMPTY;
            start = station + 1;
         }
      }

      return total < EMPTY ? INVALID : start;
   }

   public static void main(String[] args) {
      System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
      System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
   }
}
