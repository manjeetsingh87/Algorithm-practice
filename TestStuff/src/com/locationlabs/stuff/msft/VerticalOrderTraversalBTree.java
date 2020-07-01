package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class VerticalOrderTraversalBTree {
   private static class Node {
      private TreeNode node;
      private int x; // horizontal
      private int y; // depth

      protected Node(TreeNode node, int hDist, int vDist) {
         this.node = node;
         this.x = hDist;
         this.y = vDist;
      }

      @Override
      public String toString() {
         return "(" + this.node.val + " " + this.y + " " + this.x + ")";
      }
   }


   private static List<List<Integer>> verticalTraversal(TreeNode root) {
      final List<List<Integer>> result = new ArrayList<>();

      if (root == null) {
         return result;
      }

      int minHDist = 0, maxHDist = 0;
      final Map<Integer, List<Node>> map = new HashMap<>();
      final Queue<Node> queue = new LinkedList<>();
      queue.offer(new Node(root, 0, 0));

      while (!queue.isEmpty()) {
         Node curr = queue.poll();

         minHDist = Math.min(minHDist, curr.x);
         maxHDist = Math.max(maxHDist, curr.x);

         if (!map.containsKey(curr.x)) {
            map.put(curr.x, new ArrayList<>());
         }

         map.get(curr.x).add(curr);

         if (curr.node.left != null) {
            queue.offer(new Node(curr.node.left, curr.x - 1, curr.y + 1));
         }

         if (curr.node.right != null) {
            queue.offer(new Node(curr.node.right, curr.x + 1, curr.y + 1));
         }
      }

      for (int i = minHDist; i <= maxHDist; i++) {
         List<Node> currLevelVals = map.get(i);
         Collections.sort(currLevelVals, (o1, o2) -> {
            if (o1.y == o2.y) {
               return o1.node.val - o2.node.val;
            }
            return 0;
         });

         List<Integer> temp = new ArrayList<>();
         for (Node curr : currLevelVals) {
            temp.add(curr.node.val);
         }
         result.add(temp);
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(0);
      root.left = new TreeNode(2);
      root.right = new TreeNode(1);

      root.left.left = new TreeNode(3);
      root.left.left.left = new TreeNode(4);
      root.left.left.right = new TreeNode(5);

      root.left.left.left.right = new TreeNode(7);
      root.left.left.left.right.left = new TreeNode(10);
      root.left.left.left.right.right = new TreeNode(8);

      root.left.left.right.left = new TreeNode(6);
      root.left.left.right.left.left = new TreeNode(11);
      root.left.left.right.left.right = new TreeNode(9);

      System.out.println(verticalTraversal(root));
   }
}
