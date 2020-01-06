package com.locationlabs.stuff;

import java.util.*;

/*

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 6 and 8 have a common ancestor of 4.

1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   10

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 6, 5) => true

Additional example: In this diagram, 4 and 8 have a common ancestor of 10.

      10
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (10, 2), (10, 5), (1, 3), (2, 3),
    (3, 4), (5, 6), (5, 7), (7, 8)
]

hasCommonAncestor(parentChildPairs2, 4, 8) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false



 */

public class PayPal {
   private static boolean hasCommonAncestor(int[][] parentChildPairs, int child1, int child2) {
      if (parentChildPairs == null || parentChildPairs.length == 0) {
         return false;
      }

      final Map<Integer, Set<Integer>> graph = new HashMap<>();

      for (int i = 0; i < parentChildPairs.length; i++) {
         int parent = parentChildPairs[i][0];
         int child = parentChildPairs[i][1];

         if (graph.containsKey(child)) {
            graph.get(child).add(parent);
         } else {
            final Set<Integer> parents = new HashSet<>();
            parents.add(parent);
            graph.put(child, parents);
         }
      }

      if (!graph.containsKey(child1) || !graph.containsKey(child2)) {
         return false;
      }

      System.out.println(graph);

      final Set<Integer> child1Ancestors = new HashSet<>();

      // find all ancestors of child1 first
      for (Integer parent : graph.get(child1)) {
         child1Ancestors.add(parent);
         visitOtherParents(graph, parent, child1Ancestors);
      }

      // find all ancestors of child1 first
      final Set<Integer> child2Ancestors = new HashSet<>();
      for (Integer parent : graph.get(child2)) {
         child1Ancestors.add(parent);
         visitOtherParents(graph, parent, child2Ancestors);
      }

      System.out.println(child1Ancestors);
      System.out.println(child2Ancestors);


      return false;
   }

   private static void visitOtherParents(Map<Integer, Set<Integer>> graph, Integer parent, Set<Integer> child1Ancestors) {
      Set<Integer> current = graph.getOrDefault(parent, null);

      if (current == null) {
         return;
      }

      child1Ancestors.addAll(current);
      for (Integer par : current) {
         visitOtherParents(graph, par, child1Ancestors);
      }
   }

   public static void main(String[] args) {

      int[][] parentChildPairs1 = new int[][] {
              {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
              {4, 5}, {4, 8}, {8, 10}
      };

      int[][] parentChildPairs2 = new int[][] {
              {10, 2}, {10, 5}, {1, 3}, {2, 3},
              {3, 4}, {5, 6}, {5, 7}, {7, 8}
      };

      hasCommonAncestor(parentChildPairs2, 4, 8);


      // final List<List<Integer>> result = findNodesWithZeroAndOneParents(parentChildPairs);
      // System.out.println(result);
   }
}
