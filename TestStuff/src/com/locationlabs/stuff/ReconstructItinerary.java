package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 9/23/19.
 */
public class ReconstructItinerary {
   private static List<String> findItinerary(List<List<String>> tickets) {
      final LinkedList<String> result = new LinkedList<>();
      if (tickets == null || tickets.isEmpty()) {
         return result;
      }

      final Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
      for (List<String> ticket : tickets) {
         final String from = ticket.get(0);
         if (!adjMap.containsKey(from)) {
            adjMap.put(from, new PriorityQueue<>());
         }
         adjMap.get(from).offer(ticket.get(1));
      }

      System.out.println(adjMap);

      final Deque<String> stack = new ArrayDeque<>();
      stack.push("JFK");
      while (!stack.isEmpty()) {
         final String nextStop = stack.peek();
         if (adjMap.containsKey(nextStop) && !adjMap.get(nextStop).isEmpty()) {
            stack.push(adjMap.get(nextStop).poll());
         } else {
            result.addFirst(stack.pop());
         }
      }
      return result;
   }

   public static void main(String[] args) {
      List<List<String>> tickets = new ArrayList<>();
      tickets.add(Arrays.asList("MUC", "LHR"));
      tickets.add(Arrays.asList("JFK", "MUC"));
      tickets.add(Arrays.asList("SFO", "SJC"));
      tickets.add(Arrays.asList("LHR", "SFO"));

      System.out.println(findItinerary(tickets));
   }
}
