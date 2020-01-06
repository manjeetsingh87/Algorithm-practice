package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 6/14/19.
 */
public class BSTToGreaterSumTree {
   private static TreeNode convertBST(TreeNode root) {
      if (root == null) {
         return root;
      }

      TreeNode current = root;
      Deque<TreeNode> stack = new ArrayDeque<>();
      int sum = 0;

      while (!stack.isEmpty() || current != null) {
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
}
