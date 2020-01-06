package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class BTreeCompleteness {
   private static boolean isCompleteTree(TreeNode root) {
      if (root == null) {
         return true;
      }
      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      boolean isNullFound = false;
      while (!queue.isEmpty()) {
         TreeNode node = queue.poll();
         if (node == null) {
            isNullFound = true;
            continue;
         }

         if (isNullFound) {
            return false;
         }
         queue.offer(node.left);
         queue.offer(node.right);
      }

      return true;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right = new TreeNode(3);
      root.right.right = new TreeNode(6);
      System.out.println(isCompleteTree(root));
   }
}
