package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 6/23/20.
 */
public class PossibleBipartition {
   private static boolean possibleBipartition(int N, int[][] dislikes) {
      if (N <= 0 || dislikes == null || dislikes.length == 0) {
         return false;
      }

      final List<Integer>[] graph = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
         graph[i] = new ArrayList<>();
      }

      for (int[] dislike : dislikes) {
         graph[dislike[0]].add(dislike[1]);
         graph[dislike[1]].add(dislike[0]);
      }

      final Map<Integer, Integer> colours = new HashMap<>();
      for (int i = 1; i <= N; i++) {
         if (!colours.containsKey(i) && !canColourNode(graph, colours, 1, i)) {
            return false;
         }
      }

      return true;
   }

   private static boolean canColourNode(List<Integer>[] graph, Map<Integer, Integer> colours, int colour, int node) {
      if (colours.containsKey(node)) {
         return colours.get(node) == colour;
      }

      colours.put(node, colour);

      for (int neighbour : graph[node]) {
         if (!canColourNode(graph, colours, -colour, neighbour)) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
      System.out.println(possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
      System.out.println(possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
   }
}
