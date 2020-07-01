package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class CountCompleteTreeNodes {
   private static int countNodes(TreeNode root) {
      if (root == null) {
         return 0;
      }

      return findLastIndex(root, 1);
   }

   private static int findLastIndex(TreeNode node, int currIndex) {
      if (node.left == null && node.right == null) {
         return currIndex;
      }

      int lHeight = getHeight(node.left);
      int rHeight = getHeight(node.right);

      if (lHeight == rHeight) {
         return findLastIndex(node.right, currIndex * 2 + 1);
      }

      return findLastIndex(node.left, currIndex * 2);
   }

   private static int getHeight(TreeNode node) {
      return node == null ? 0 : 1 + getHeight(node.left);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);

      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      root.right.left = new TreeNode(6);
      //root.right.right = new TreeNode(7);

      System.out.println(countNodes(root));
   }
}
