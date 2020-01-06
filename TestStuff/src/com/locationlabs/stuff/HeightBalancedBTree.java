package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/4/19.
 */
public class HeightBalancedBTree {
   private static boolean isBalanced(TreeNode root) {
      return getHeight(root, 0) >= 0;
   }

   private static int getHeight(TreeNode root, int height) {
      if (root == null) {
         return height;
      }

      int leftTreeHeight = getHeight(root.left, height+1);
      int rightTreeHeight = getHeight(root.right, height+1);

      if (leftTreeHeight < 0 || rightTreeHeight < 0 || Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
         return -1;
      }

      return Math.max(leftTreeHeight, rightTreeHeight);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(3);
      /*root.left.left.left = new TreeNode(4);
      root.left.left.right = new TreeNode(4);*/
      System.out.println(isBalanced(root));
   }
}
