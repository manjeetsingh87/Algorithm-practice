package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 5/13/20.
 */
public class HouseRobberIII {
   private static int rob(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int[] result = maxMoney(root);
      return Math.max(result[0], result[1]);
   }

   // return int[] result: result[0] = max Money excluding the node, result[1] = max Money including this node
   private static int[] maxMoney(TreeNode node) {
      if (node == null) {
         return new int[2];
      }

      int[] left = maxMoney(node.left);
      int[] right = maxMoney(node.right);

      int[] result = new int[2];
      result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
      result[1] = node.val + left[0] + right[0];

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(4);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(3);
      root.right.right = new TreeNode(1);

      System.out.println(rob(root));
   }
}
