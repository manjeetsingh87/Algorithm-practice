package com.locationlabs.stuff.apple;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class LongestUnivaluePath {
   private static int longestUnivaluePath(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int left = helper(root.left, root.val);
      int right = helper(root.right, root.val);

      int max = Math.max(left + right, Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));

      return max;
   }

   private static int helper(TreeNode node, int val) {
      if (node == null || node.val != val) {
         return 0;
      }

      return 1 + Math.max(helper(node.left, val), helper(node.right, val));
   }

   private static int max = 0;
   private static int longestUnivaluePathApproachII(TreeNode root) {
      if (root == null) {
         return 0;
      }

      dfs(root);
      return max;
   }

   private static int dfs(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int left = dfs(node.left);
      int right = dfs(node.right);

      int leftMax = 0, rightMax = 0;

      if (node.left != null && node.left.val == node.val) {
         leftMax += left + 1;
      }

      if (node.right != null && node.right.val == node.val) {
         rightMax += right + 1;
      }

      max = Math.max(max, leftMax + rightMax);

      return Math.max(leftMax, rightMax);
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(4);
      root.right = new TreeNode(5);

      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(4);

      root.right.left = new TreeNode(5);

      System.out.println(longestUnivaluePath(root));
      System.out.println(longestUnivaluePathApproachII(root));
   }
}
