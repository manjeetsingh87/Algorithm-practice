package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import com.sun.org.apache.bcel.internal.generic.INEG;

/**
 * Created by manjeet.singh on 7/26/19.
 */
public class BTreeDiameter {
   private static int maxDiameter = Integer.MIN_VALUE;
   private static int diameterOfBinaryTree(TreeNode root) {
      if (root == null) {
         return 0;
      }
      getDiameter(root);
      return maxDiameter - 1;
   }

   private static int getDiameter(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int left = getDiameter(node.left);
      int right = getDiameter(node.right);
      maxDiameter = Math.max(maxDiameter, (left + right + 1));
      return Math.max(left, right) + 1;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      System.out.println(diameterOfBinaryTree(root));
   }
}
