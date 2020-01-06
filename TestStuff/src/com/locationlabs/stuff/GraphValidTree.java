package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/14/19.
 */
public class GraphValidTree {
   private static boolean validTree(int n, int[][] edges) {
      if (edges == null || edges.length == 0 || n <= 0) {
         return false;
      }

      final Map<Integer, List<Integer>> graph = new HashMap<>();
      for (int i = 0; i < n; i++) {
         graph.put(i, new ArrayList<>());
      }

      for (int[] edge : edges) {
         int u = edge[0];
         int v = edge[1];
         graph.get(u).add(v);
         graph.get(v).add(u);
      }

      boolean[] visited = new boolean[n];
      if (!dfs(graph, visited, 0, -1)) {
         return false;
      }

      for (boolean isVisited : visited) {
         if (!isVisited) {
            return false;
         }
      }

      return true;
   }

   private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int child, int parent) {
      if (visited[child]) {
         return false;
      }

      visited[child] = true;
      for (int neighbor : graph.get(child)) {
         if ((neighbor != parent) && !dfs(graph, visited, neighbor, child)) {
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
      System.out.println(validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
   }
}
