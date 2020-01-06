package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/9/19.
 */
public class AllNodesDistKBTree {
   private static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      final List<Integer> result = new ArrayList<>();

      if (root == null || K < 0) {
         return result;
      }

      final Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
      buildGraph(root, null, graph);

      if (!graph.containsKey(target)) {
         return result;
      }

      if (K == 0) {
         result.add(target.val);
         return result;
      }

      final Set<TreeNode> visited = new HashSet<>();
      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(target);
      visited.add(target);

      while (!queue.isEmpty()) {
         int size = queue.size();

         if (K == 0) {
            for (int i = 0; i < size; i++) {
               result.add(queue.poll().val);
            }
            return result;
         }

         for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            for (TreeNode neighbor : graph.get(node)) {
               if (visited.add(neighbor)) {
                  queue.offer(neighbor);
               }
            }
         }
         K--;
      }

      return result;
   }

   private static void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
      if (node == null) {
         return;
      }

      if (!graph.containsKey(node)) {
         graph.put(node, new ArrayList<>());
         if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
         }
         buildGraph(node.left, node, graph);
         buildGraph(node.right, node, graph);
      }
   }

   public static void main(String[] args) {
      final TreeNode target = new TreeNode(5);
      target.left = new TreeNode(6);
      target.right = new TreeNode(2);
      target.right.left = new TreeNode(7);
      target.right.right = new TreeNode(4);

      final TreeNode root = new TreeNode(3);
      root.left = target;
      root.right = new TreeNode(1);
      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);

      System.out.println(distanceK(root, target, 2));
   }
}
