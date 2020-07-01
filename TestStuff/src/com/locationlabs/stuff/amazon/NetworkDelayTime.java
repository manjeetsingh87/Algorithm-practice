package com.locationlabs.stuff.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class NetworkDelayTime {
   // Time complexity: O(Nlog(N) + E)
   // Space complexity: O(N + E)
   private static int networkDelayTime(int[][] times, int N, int K) {
      if (times == null || times.length == 0 || N < 0 || K < 0) {
         return -1;
      }

      final Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();
      for (int[] time : times) {
         adjMap.putIfAbsent(time[0], new HashMap<>());
         adjMap.get(time[0]).put(time[1], time[2]);
      }

      final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
      pq.offer(new int[]{K, 0});

      final Set<Integer> visited = new HashSet<>();

      while (!pq.isEmpty()) {
         final int[] curr = pq.poll();
         final int currNode = curr[0];
         final int currWeight = curr[1];

         if (!visited.add(currNode)) {
            continue;
         }

         N--;

         if (N == 0) {
            return currWeight;
         }

         if (adjMap.containsKey(currNode)) {
            for (int next : adjMap.get(currNode).keySet()) {
               pq.offer(new int[]{next, currWeight + adjMap.get(currNode).get(next)});
            }
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
   }
}
