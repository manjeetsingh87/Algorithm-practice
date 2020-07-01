package com.locationlabs.stuff.amazon;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class MinCostToConnectSticks {
   private static int connectSticks(int[] sticks) {
      if (sticks == null || sticks.length <= 1) {
         return 0;
      }

      final Queue<Integer> pq = new PriorityQueue<>();
      for (int stick : sticks) {
         pq.offer(stick);
      }

      int cost = 0;
      while (pq.size() > 1) {
         final int currCost = pq.poll() + pq.poll();
         cost += currCost;
         pq.offer(currCost);
      }

      return cost;
   }

   public static void main(String[] args) {
      System.out.println(connectSticks(new int[]{2, 4, 3}));
      System.out.println(connectSticks(new int[]{1, 8, 3, 5}));
   }
}
