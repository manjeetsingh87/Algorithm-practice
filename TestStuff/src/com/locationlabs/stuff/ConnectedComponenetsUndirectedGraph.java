package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/12/19.
 */
public class ConnectedComponenetsUndirectedGraph {
   private static int countComponents(int n, int[][] edges) {
      Map<Integer, List<Integer>> graph = new HashMap<>();
      for (int i = 0; i < n; i++) {
         graph.put(i, new ArrayList<>());
      }

      for (int[] edge : edges) {
         graph.get(edge[0]).add(edge[1]);
         graph.get(edge[1]).add(edge[0]);
      }

      boolean[] visited = new boolean[n];
      int count = 0;
      for (int i = 0; i < n; i++) {
         if (!visited[i]) {
            visited[i] = true;
            dfs(i, graph, visited);
            count++;
         }
      }

      return count;
   }

   private static void dfs(int index, Map<Integer, List<Integer>> graph, boolean[] visited) {
      graph.get(index).stream().filter(j -> !visited[j]).forEach(neighbor -> {
         visited[neighbor] = true;
         dfs(neighbor, graph, visited);
      });
   }

   public static void main(String[] args) {
      System.out.println(countComponents(5, new int[][]{{0,1}, {1,2}, {3,4}}));
      System.out.println(countComponents(4, new int[][]{{0,1}, {1,2}, {3,2}}));
   }
}
