package com.locationlabs.stuff;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class SymmetricTrees {

   public static boolean isSymmetric(TreeNode root) {
      if (root == null) {
         return true;
      }

      return isSymmetric(root.left, root.right);
   }

   private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
      if (node1 == null && node2 == null) {
         return true;
      }

      if (node1 == null || node2 == null) {
         return false;
      }

      return (node1.val == node2.val) &&
              isSymmetric(node1.left, node2.right) &&
              isSymmetric(node1.right, node2.left);
   }

   private static boolean isSymmetricItr(TreeNode root) {
      if (root == null) {
         return true;
      }

      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      queue.offer(root);

      while (!queue.isEmpty()) {
         TreeNode temp1 = queue.poll();
         TreeNode temp2 = queue.poll();

         if (temp1 == null && temp2 == null) {
            continue;
         }

         if (temp1 == null || temp2 == null) {
            return false;
         }

         if (temp1.val != temp2.val) {
            return false;
         }

         queue.offer(temp1.left);
         queue.offer(temp2.right);
         queue.offer(temp1.right);
         queue.offer(temp2.left);
      }

      return true;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);

      System.out.println(isSymmetric(root));
      System.out.println(isSymmetricItr(root));

      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.right = new TreeNode(3);
      root.right.right = new TreeNode(3);
      System.out.println(isSymmetric(root));
   }
}
