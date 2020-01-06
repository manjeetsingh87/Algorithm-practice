package com.locationlabs.stuff.apple;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 8/20/19.
 */
public class LeftLeavesSum {
   private static int sumOfLeftLeaves(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int sum = 0;
      final Deque<TreeNode> stack = new ArrayDeque<>();
      stack.offer(root);
      while (!stack.isEmpty()) {
         TreeNode curr = stack.poll();
         if (curr.left != null) {
            if (curr.left.left == null && curr.left.right == null) {
               sum += curr.left.val;
            } else {
               stack.offer(curr.left);
            }
         }

         if (curr.right != null) {
            if (curr.right.left != null || curr.right.right != null) {
               stack.offer(curr.right);
            }
         }
      }

      return sum;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      System.out.println(sumOfLeftLeaves(root));
   }
}
