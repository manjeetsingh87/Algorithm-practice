package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/20/19.
 */
public class BTreePreorderTraversal {
   public static List<Integer> preOrderTraversal(TreeNode root) {
      final List<Integer> result = new ArrayList<>();

      if (root == null) {
         return result;
      }

      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      while (!stack.isEmpty()) {
         TreeNode current = stack.pop();
         result.add(current.val);

         if (current.right != null) {
            stack.push(current.right);
         }

         if (current.left != null) {
            stack.push(current.left);
         }
      }

      return result;
   }

   private static List<Integer> postOrderTraversal(TreeNode root) {
      final LinkedList<Integer> result = new LinkedList<>();

      if (root == null) {
         return result;
      }

      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      while (!stack.isEmpty()) {
         TreeNode current = stack.pop();
         result.addFirst(current.val);

         if (current.left != null) {
            stack.push(current.left);
         }

         if (current.right != null) {
            stack.push(current.right);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      /*root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);*/

      System.out.println(preOrderTraversal(root));
      System.out.println(postOrderTraversal(root));
   }
}
