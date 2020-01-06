package com.locationlabs.stuff.apple;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 8/20/19.
 */
public class MinAbsoluteDiffBST {
   private static int getMinimumDifference(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int[] bound = {-1, Integer.MAX_VALUE};
      inorder(root, bound);
      return bound[1];
   }

   private static int[] inorder(TreeNode node, int[] bound) {
      if (node == null) {
         return bound;
      }

      int current = bound[1];
      int[] left = inorder(node.left, bound);
      if (left[0] != -1) {
         current = Math.min(bound[1], node.val - bound[0]);
      }
      bound[0] = node.val;
      bound[1] = current;
      return inorder(node.right, bound);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(4);
      root.right = new TreeNode(7);
      System.out.println(getMinimumDifference(root));
   }
}
