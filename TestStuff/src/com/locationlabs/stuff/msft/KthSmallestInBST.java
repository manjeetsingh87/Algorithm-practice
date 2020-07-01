package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.Stack;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class KthSmallestInBST {
   private static int kthSmallest(TreeNode root, int k) {
      if (root == null || k <= 0) {
         return -1;
      }

      Stack<TreeNode> stack = new Stack<>();
      inorder(root, stack);

      while (k != 0) {
         TreeNode curr = stack.pop();
         k--;
         if (k == 0) {
            return curr.val;
         }
         TreeNode right = curr.right;
         inorder(right, stack);
      }
      return -1;
   }

   private static void inorder(TreeNode root, Stack<TreeNode> stack) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(33);
      root.right.left = new TreeNode(25);
      root.right.left.left = new TreeNode(11);
      root.right.left.left.left = new TreeNode(7);
      root.right.left.left.right = new TreeNode(12);
      root.right.left.left.right.right = new TreeNode(13);
      root.right.right = new TreeNode(40);
      root.right.right.left = new TreeNode(34);
      root.right.right.left.right = new TreeNode(36);

      System.out.println(kthSmallest(root, 3));
      System.out.println(kthSmallest(root, 5));
   }

}
