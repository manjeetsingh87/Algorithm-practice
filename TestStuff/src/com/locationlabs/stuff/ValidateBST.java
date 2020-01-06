package com.locationlabs.stuff;

import java.util.Stack;

/**
 * Created by manjeet.singh on 5/16/19.
 */
public class ValidateBST {

   private static boolean isValidBST(TreeNode root) {
      if (root == null) {
         return true;
      }

      return validateBST(root, null, null);
   }

   private static boolean validateBST(TreeNode node, Integer leftVal, Integer rightVal) {
      if (node == null) {
         return true;
      }

      if (leftVal != null && node.val <= leftVal) {
         return false;
      }

      if (rightVal != null && node.val >= rightVal) {
         return false;
      }

      return validateBST(node.left, leftVal, node.val) && validateBST(node.right, node.val, rightVal);
   }

   private static boolean validateBst(TreeNode root) {
      if (root == null) {
         return true;
      }

      Stack<TreeNode> stack = new Stack<>();
      long prevRootVal = Long.MIN_VALUE;

      while (!stack.isEmpty() || root != null) {
         while (root != null) {
            stack.push(root);
            root = root.left;
         }

         root = stack.pop();

         if (root.val <= prevRootVal) {
            return false;
         }

         prevRootVal = root.val;
         root = root.right;
      }

      return true;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);

      System.out.println(isValidBST(root));
      System.out.println(validateBst(root));
   }

}
