package com.locationlabs.stuff;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class InvertBTree {
   private static TreeNode invertTree(TreeNode root) {
      if (root == null) {
         return null;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         TreeNode curr = queue.poll();

         TreeNode temp = curr.left;
         curr.left = curr.right;
         curr.right = temp;

         if (curr.left != null) {
            queue.offer(curr.left);
         }
         if (curr.right != null) {
            queue.offer(curr.right);
         }
      }

      return root;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);

      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);

      root.right.left = new TreeNode(6);
      root.right .right= new TreeNode(9);

      TreeNode result = invertTree(root);
      System.out.println(result);
   }
}
