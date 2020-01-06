package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/11/19.
 */
public class DeleteBSTNode {
   private static TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
         return root;
      }

      if (key < root.val) {
         root.left = deleteNode(root.left, key);
      } if (key > root.val) {
         root.right = deleteNode(root.right, key);
      } else {
         if (root.left == null) {
            return root.right;
         }

         if (root.right == null) {
            return root.left;
         }

         root.val = getMin(root.right);
         root.right = deleteNode(root.right, root.val);
      }

      return root;
   }

   private static int getMin(TreeNode root) {
      while (root.left != null) {
         root = root.left;
      }

      return root.val;
   }
}
