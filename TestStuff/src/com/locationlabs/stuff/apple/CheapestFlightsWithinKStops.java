package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 6/3/20.
 */
public class CheapestFlightsWithinKStops {
   private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
      if (n <= 0 || flights == null || flights.length == 0 || K < 0) {
         return -1;
      }

      final Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();
      for (int[] flight : flights) {
         adjMap.computeIfAbsent(flight[0], v -> new HashMap<>()).put(flight[1], flight[2]);
      }

      final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
      pq.offer(new int[]{0, src, K + 1});

      while (!pq.isEmpty()) {
         final int[] curr = pq.poll();
         final int cost = curr[0];
         final int city = curr[1];
         final int stops = curr[2];

         if (city == dst) {
            return cost;
         }

         if (stops > 0) {
            final Map<Integer, Integer> adj = adjMap.getOrDefault(city, new HashMap<>());
            for (int c : adj.keySet()) {
               pq.offer(new int[]{cost + adj.get(c), c, stops - 1});
            }
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 200}, {0, 2, 500}}, 0, 2, 1));
      System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 200}, {0, 2, 500}}, 0, 2, 0));
   }
}
