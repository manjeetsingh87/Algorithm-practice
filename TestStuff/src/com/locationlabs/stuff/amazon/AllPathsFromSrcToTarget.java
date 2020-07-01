package com.locationlabs.stuff.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 6/8/20.
 */
public class AllPathsFromSrcToTarget {
   private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      final List<List<Integer>> result = new ArrayList<>();

      if (graph == null || graph.length == 0) {
         return result;
      }

      final Queue<List<Integer>> queue = new LinkedList<>();
      queue.offer(Arrays.asList(0));

      final int target = graph.length - 1;

      while (!queue.isEmpty()) {
         final List<Integer> curr = queue.poll();
         final int last = curr.get(curr.size() - 1);

         if (last == target) {
            result.add(curr);
         } else {
            final int[] neighbours = graph[last];
            for (int neighbour : neighbours) {
               final List<Integer> next = new ArrayList<>(curr);
               next.add(neighbour);
               queue.offer(next);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
   }
}
