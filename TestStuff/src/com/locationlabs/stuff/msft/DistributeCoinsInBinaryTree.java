package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 4/3/20.
 */
public class DistributeCoinsInBinaryTree {
   static int moves = 0;

   private static int distributeCoins(TreeNode root) {
      moves = 0;
      if (root == null) {
         return moves;
      }

      helper(root);
      return moves;
   }

   private static int helper(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int leftMoves = helper(node.left);
      int rightMoves = helper(node.right);

      moves += Math.abs(leftMoves) + Math.abs(rightMoves);
      return node.val + leftMoves + rightMoves - 1;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(0);
      root.left = new TreeNode(3);
      root.right = new TreeNode(0);
      System.out.println(distributeCoins(root));

      root = new TreeNode(1);
      root.left = new TreeNode(0);
      root.right = new TreeNode(2);
      System.out.println(distributeCoins(root));

      root = new TreeNode(1);
      root.left = new TreeNode(0);
      root.left.right = new TreeNode(3);
      root.right = new TreeNode(0);
      System.out.println(distributeCoins(root));
   }
}
