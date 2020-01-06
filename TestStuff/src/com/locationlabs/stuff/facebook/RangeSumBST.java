package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class RangeSumBST {
   private static int rangeSumBST(TreeNode root, int L, int R) {
      if (root == null) {
         return 0;
      }

      final Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);

      int sum = 0;

      while (!stack.isEmpty()) {
         final TreeNode current = stack.pop();

         int currentVal = current.val;
         if (currentVal >= L && currentVal <= R) {
            sum += currentVal;
         }

         if (currentVal > L && current.left != null) {
            stack.push(current.left);
         }

         if (currentVal < R && current.right != null) {
            stack.push(current.right);
         }
      }
      return sum;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(7);
      root.right = new TreeNode(15);
      root.right.right = new TreeNode(17);
      System.out.println(rangeSumBST(root, 7, 15));
   }
}
