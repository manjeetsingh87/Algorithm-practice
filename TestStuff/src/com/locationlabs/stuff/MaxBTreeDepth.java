package com.locationlabs.stuff;

import java.util.Stack;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class MaxBTreeDepth {
   public static int maxDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }

      Stack<TreeNode> nodeStack = new Stack<>();
      Stack<Integer> depthStack = new Stack<>();
      int maxDepth = 1;

      nodeStack.push(root);
      depthStack.push(maxDepth);

      while (!depthStack.isEmpty()) {
         TreeNode currNode = nodeStack.pop();
         int currDepth = depthStack.pop();
         maxDepth = Math.max(maxDepth, currDepth);

         if (currNode.left != null) {
            nodeStack.push(currNode.left);
            depthStack.push(currDepth+1);
         }

         if (currNode.right != null) {
            nodeStack.push(currNode.right);
            depthStack.push(currDepth+1);
         }
      }

      return maxDepth;
   }

   private static int maxDepthRec(TreeNode root) {
      if (root == null) {
         return 0;
      }

      return 1 + Math.max(maxDepthRec(root.left), maxDepthRec(root.right));
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.left.left = null;
      root.left.right = null;
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      System.out.println(maxDepth(root));
      System.out.println(maxDepthRec(root));
   }
}
