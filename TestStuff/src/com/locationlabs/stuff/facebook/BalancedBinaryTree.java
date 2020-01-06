package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class BalancedBinaryTree {
   private static boolean isBalanced(TreeNode root) {
      if (root == null) {
         return true;
      }

      return getHeight(root) != -1;
   }

   private static int getHeight(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int left = getHeight(node.left);
      if (left == -1) {
         return -1;
      }

      int right = getHeight(node.right);
      if (right == -1) {
         return -1;
      }

      if (Math.abs(left - right) > 1) {
         return -1;
      }

      return Math.max(left, right) + 1;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println(isBalanced(root));

      final TreeNode root2 = new TreeNode(1);
      root2.left = new TreeNode(2);
      root2.right = new TreeNode(2);
      root2.left.left = new TreeNode(3);
      root2.left.right = new TreeNode(3);
      root2.left.left.left = new TreeNode(4);
      root2.left.left.right = new TreeNode(4);
      System.out.println(isBalanced(root2));
   }
}
