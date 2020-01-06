package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class BTreeLongestConsecutiveSequence {
   private static int maxLength = 0;
   private static int longestConsecutive(TreeNode root) {
      if (root == null) {
         return maxLength;
      }

      dfs(root, root.val, 0);
      return maxLength;
   }

   private static void dfs(TreeNode node, int target, int length) {
      if (node == null) {
         return;
      }

      if (node.val == target) {
         length+= 1;
      } else {
         length = 1;
      }

      maxLength = Math.max(length, maxLength);
      dfs(node.left, node.val + 1, length);
      dfs(node.right, node.val + 1, length);
   }

   private static int longestConsecutiveII(TreeNode root) {
      if (root == null) {
         return maxLength;
      }

      traverse(root);

      return maxLength;
   }

   private static Result traverse(TreeNode node) {
      if (node == null) {
         return null;
      }

      Result left = traverse(node.left);
      Result right = traverse(node.right);

      Result curr = new Result(node, 1, 1);
      if (left != null) {
         if (node.val == left.node.val + 1) {
            curr.inc = Math.max(curr.inc, left.inc + 1);
         } else if (node.val == left.node.val - 1) {
            curr.des = Math.max(curr.des, left.des + 1);
         }
      }

      if (right != null) {
         if (node.val == right.node.val + 1) {
            curr.inc = Math.max(curr.inc, right.inc + 1);
         } else if (node.val == right.node.val - 1) {
            curr.des = Math.max(curr.des, right.des + 1);
         }
      }

      maxLength = Math.max(maxLength, curr.inc + curr.des - 1);
      return curr;
   }

   private static class Result {
      TreeNode node;
      int inc;
      int des;

      private Result(TreeNode node, int inc, int des) {
         this.node = node;
         this.inc = inc;
         this.des = des;
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(2);
      root.right.right = new TreeNode(4);
      root.right.right.right = new TreeNode(5);
      System.out.println(longestConsecutive(root));

      maxLength = 0;
      TreeNode root1 = new TreeNode(2);
      root1.left = new TreeNode(1);
      root1.right = new TreeNode(3);
      System.out.println(longestConsecutiveII(root1));
   }
}
