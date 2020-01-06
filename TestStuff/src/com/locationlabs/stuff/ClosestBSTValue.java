package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class ClosestBSTValue {

   private static int closestValue(TreeNode root, double target) {
      if (root == null) {
         return 0;
      }
      int closest = root.val;

      while (root != null) {
         closest = (Math.abs(target-root.val) < Math.abs(target-closest)) ? root.val : closest;
         if (closest == target) {
            return closest;
         }

         root = (root.val > target) ? root.left : root.right;
      }

      return closest;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);

      System.out.println(closestValue(root, 3.714286));
   }
}
