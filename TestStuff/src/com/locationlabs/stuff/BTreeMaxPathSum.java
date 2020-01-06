package com.locationlabs.stuff;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any
 * node in the tree along the parent-child connections. The path must contain at least one node
 * and does not need to go through the root.
 * Input: [1,2,3]
 *    1
 *   / \
 *  2  3
 * Output: 6
 */
public class BTreeMaxPathSum {
   private static int maxSum = Integer.MIN_VALUE;

   private static int maxPathSum(TreeNode root) {
      findMaxSum(root);
      return maxSum;
   }

   private static int findMaxSum(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int leftSum = findMaxSum(node.left);
      int rightSum = findMaxSum(node.right);

      maxSum = Math.max(leftSum + rightSum + node.val, maxSum);

      return Math.max(0, Math.max(leftSum, rightSum) + node.val);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println(maxPathSum(root));

      /*maxSum = Integer.MIN_VALUE;
      root = new TreeNode(-2);
      root.left = new TreeNode(-1);
      System.out.println(maxPathSum(root));*/
   }
}
