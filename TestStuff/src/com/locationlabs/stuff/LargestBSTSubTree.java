package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class LargestBSTSubTree {
   private static int largestBSTSubtree(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int[] result = findLargestSubTree(root);
      return result[2];
   }

   /**
    * return array for each node:
    *    elem [0] --> min
    *    elem [1] --> max
    *    elem [2] --> largest BST in its subtree(inclusive)
    */
   private static int[] findLargestSubTree(TreeNode node) {
      if (node == null) {
         return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
      }

      int[] left = findLargestSubTree(node.left);
      int[] right = findLargestSubTree(node.right);
      if (node.val > left[1] && node.val < right[0]) {
         return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
      } else {
         return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(8);
      root.right = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println(largestBSTSubtree(root));
   }

}
