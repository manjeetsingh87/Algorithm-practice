package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class InsertInBST {
   private TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null) {
         return new TreeNode(val);
      }

      TreeNode node = root;

      while (node != null) {
         if (node.val < val) {
            if (node.right == null) {
               node.right = new TreeNode(val);
               return root;
            } else {
               node = node.right;
            }
         } else {
            if (node.left == null) {
               node.left = new TreeNode(val);
               return root;
            } else {
               node = node.left;
            }
         }
      }
      return new TreeNode(val);
   }
}
