package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/11/19.
 */
public class BinaryTreeUpsideDown {
   private static TreeNode upsideDownBinaryTree(TreeNode root) {
      if (root == null) {
         return root;
      }

      TreeNode curr = root;
      TreeNode prev = null;
      TreeNode temp = null;

      while (curr != null) {
         TreeNode next = curr.left;

         curr.left = temp;
         temp = curr.right;
         curr.right = prev;

         prev = curr;
         curr = next;
      }

      return prev;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      TreeNode newRoot = upsideDownBinaryTree(root);
      System.out.println(BTreePreorderTraversal.preOrderTraversal(newRoot));
   }
}
