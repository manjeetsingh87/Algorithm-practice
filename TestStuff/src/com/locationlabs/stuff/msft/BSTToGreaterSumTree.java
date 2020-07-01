package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 4/3/20.
 */
public class BSTToGreaterSumTree {
   private static TreeNode bstToGst(TreeNode root) {
      if (root == null) {
         return root;
      }

      final Deque<TreeNode> stack = new ArrayDeque<>();

      TreeNode current = root;
      int sum = 0;
      while (current != null || !stack.isEmpty()) {
         while (current != null) {
            stack.push(current);
            current = current.right;
         }

         current = stack.pop();
         sum += current.val;
         current.val = sum;
         current = current.left;
      }

      return root;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(1);
      root.left.left = new TreeNode(0);
      root.left.right = new TreeNode(2);
      root.left.right.right = new TreeNode(3);

      root.right = new TreeNode(6);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(7);
      root.right.right.right = new TreeNode(8);

      final TreeNode result = bstToGst(root);

      System.out.println(com.locationlabs.stuff.LevelOrderTraversal.levelOrder(result));
   }
}
