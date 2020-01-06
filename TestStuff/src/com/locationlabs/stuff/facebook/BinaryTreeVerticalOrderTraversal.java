package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class BinaryTreeVerticalOrderTraversal {
   private static List<List<Integer>> verticalOrder(TreeNode root) {
      final List<List<Integer>> result = new ArrayList<>();

      if (root == null) {
         return result;
      }

      final Map<Integer, List<Integer>> map = new HashMap<>();
      final Queue<TreeNode> nodeQueue = new LinkedList<>();
      final Queue<Integer> colQueue = new LinkedList<>();

      nodeQueue.offer(root);
      colQueue.offer(0);
      int min = 0;

      while (!nodeQueue.isEmpty()) {
         final TreeNode node = nodeQueue.poll();
         final int col = colQueue.poll();

         if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
         }

         map.get(col).add(node.val);

         if (node.left != null) {
            nodeQueue.offer(node.left);
            colQueue.offer(col - 1);
            min = Math.min(min, col - 1);
         }

         if (node.right != null) {
            nodeQueue.offer(node.right);
            colQueue.offer(col + 1);
            min = Math.min(min, col + 1);
         }
      }

      while (map.containsKey(min)) {
         result.add(map.get(min++));
      }

      return result;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(0);
      root.left.right.left = new TreeNode(5);
      root.left.right.right = new TreeNode(2);

      root.right = new TreeNode(8);
      root.right.left = new TreeNode(1);
      root.right.right = new TreeNode(7);

      System.out.println(verticalOrder(root));
   }
}
