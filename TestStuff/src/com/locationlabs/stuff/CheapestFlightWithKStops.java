package com.locationlabs.stuff;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class CheapestFlightWithKStops {
   private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
      if (flights == null || flights.length == 0 || K < 0) {
         return -1;
      }

      final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
      for (int[] flight : flights) {
         if (!graph.containsKey(flight[0])) {
            graph.put(flight[0], new HashMap<>());
         }
         graph.get(flight[0]).put(flight[1], flight[2]);
      }

      final Queue<int[]> queue = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
      queue.add(new int[]{0, src, -1});
      while (!queue.isEmpty()) {
         int[] current = queue.remove();
         int price = current[0];
         int currCity = current[1];
         int stop = current[2];

         if (currCity == dst) {
            return price;
         }

         if (stop < K) {
            final Map<Integer, Integer> adjMap = graph.getOrDefault(currCity, new HashMap<>());
            for (int city : adjMap.keySet()) {
               queue.add(new int[]{price + adjMap.get(city), city, stop + 1});
            }
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0 , 2, 1));
      System.out.println(findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0 , 2, 0));
   }
}
