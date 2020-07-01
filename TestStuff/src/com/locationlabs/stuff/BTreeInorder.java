package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/20/19.
 */
public class BTreeInorder {

   public static List<Integer> inorderTraversal(TreeNode root) {
      final List<Integer> result = new ArrayList<>();

      if (root == null) {
         return result;
      }

      Stack<TreeNode> stack = new Stack<>();

      while (!stack.isEmpty() || root != null) {
         while (root != null) {
            stack.push(root);
            root = root.left;
         }

         TreeNode current = stack.pop();
         result.add(current.val);
         root = current.right;
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.left.left = new TreeNode(2);
      root.left.left.left = new TreeNode(1);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(6);

      System.out.println(inorderTraversal(root));
   }
}
