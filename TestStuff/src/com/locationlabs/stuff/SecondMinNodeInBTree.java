package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class SecondMinNodeInBTree {
   private static int findSecondMinimumValue(TreeNode root) {
      if (root == null) {
         return -1;
      }

      if (root.left == null && root.right == null) {
         return -1;
      }

      int left = (root.left.val == root.val) ? findSecondMinimumValue(root.left) : root.left.val;
      int right = (root.right.val == root.val) ? findSecondMinimumValue(root.right) : root.right.val;

      if (left == -1) {
         return right;
      } else if (right == -1) {
         return left;
      } else {
         return Math.min(left, right);
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(7);
      System.out.println(findSecondMinimumValue(root));

      root = new TreeNode(2);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      System.out.println(findSecondMinimumValue(root));
   }
}
