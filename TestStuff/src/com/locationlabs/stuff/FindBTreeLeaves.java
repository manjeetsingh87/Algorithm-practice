package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 6/10/19.
 */
public class FindBTreeLeaves {
   private static List<List<Integer>> findLeaves(TreeNode root) {
      final List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
         return result;
      }
      findMaxHeght(root, result);
      return result;
   }

   private static int findMaxHeght(TreeNode node, List<List<Integer>> result) {
      if (node == null) {
         return -1;
      }

      int level = 1 + Math.max(findMaxHeght(node.left, result),
                               findMaxHeght(node.right, result)
                              );

      if (level == result.size()) {
         result.add(level, new ArrayList<>());
      }

      result.get(level).add(node.val);
      node.left = null;
      node.right = null;
      return level;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      System.out.println(findLeaves(root));
   }
}
