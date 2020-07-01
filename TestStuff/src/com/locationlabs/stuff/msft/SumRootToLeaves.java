package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import com.sun.source.tree.Tree;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class SumRootToLeaves {
   private static int total = 0;
   private static int sumNumbers(TreeNode root) {
      if (root == null) {
         return total;
      }

      dfs(root, 0);

      return total;
   }

   private static void dfs(TreeNode node, int currSum) {
      if (node == null) {
         return;
      }

      currSum = currSum * 10 + node.val;

      if (node.left == null && node.right == null) {
         total += currSum;
         return;
      }

      dfs(node.left, currSum);
      dfs(node.right, currSum);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(9);
      root.left.left = new TreeNode(5);
      root.left.right = new TreeNode(1);
      root.right = new TreeNode(0);
      System.out.println(sumNumbers(root));
   }
}
