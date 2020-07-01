package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;
/**
 * Created by manjeet.singh on 5/8/20.
 */
public class SumNodesWithEvenValuedGrandParents {
   private static int total = 0;

   private static int sumEvenGrandparent(TreeNode root) {
      if (root == null) {
         return 0;
      }

      dfs(root, null, null);

      return total;
   }

   private static void dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {
      if (current == null) {
         return;
      }

      if (grandParent != null && grandParent.val % 2 == 0) {
         total += current.val;
      }

      dfs(current.left, current, parent);
      dfs(current.right, current, parent);
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(6);
      root.left = new TreeNode(10);
      root.right = new TreeNode(8);

      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(7);

      root.left.left.left = new TreeNode(1);

      root.left.right.left = new TreeNode(1);
      root.left.right.right = new TreeNode(4);

      root.right.left = new TreeNode(1);
      root.right.right = new TreeNode(3);
      root.right.right.right = new TreeNode(5);

      System.out.println(sumEvenGrandparent(root));
   }
}
