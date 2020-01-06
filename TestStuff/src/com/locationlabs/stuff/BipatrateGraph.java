package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/22/19.
 */
public class BipatrateGraph {
   private static boolean isBipartite(int[][] graph) {
      if (graph == null || graph.length == 0) {
         return false;
      }

      int graphLen = graph.length;
      // default all node colors to 0
      int[] colors = new int[graphLen];

      for (int i = 0; i < graphLen; i++) {
         // if this node has not be colored, check if we can color this node.
         if (colors[i] == 0 && !canColorNode(graph, colors, 1, i)) {
            return false;
         }
      }

      return true;
   }

   private static boolean canColorNode(int[][] graph, int[] colors, int color, int node) {
      /**
       * If node color is not 0, that means that the node is already colored.
       * If the color is not the same as this color,
       * then return false since it has an edge from more than one node;
       */
      if (colors[node] != 0) {
         return colors[node] == color;
      }

      // color this node with the color
      colors[node] = color;

      // DFS visit all adjacent nodes to this node and check if we can color them
      // with the opposite of this color.
      // e.g if node 1 was colored 1 then its adjacent nodes should be able to be colored as -1;
      for (int neighbour : graph[node]) {
         if (!canColorNode(graph, colors, -color, neighbour)) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
      System.out.println(isBipartite(graph));
   }
}
