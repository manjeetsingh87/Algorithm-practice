package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
/**
 * Created by manjeet.singh on 4/11/20.
 */
public class InorderSuccessorBST {
   private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null) {
         return null;
      }

      TreeNode result = null;

      while (root != null) {
         if (root.val > p.val) {
            result = root;
            root = root.left;
         } else {
            root = root.right;
         }
      }

      return result;
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

      final TreeNode successor = inorderSuccessor(root, new TreeNode(40));
      System.out.println(successor == null ? "NULL" : successor.val);
   }

   private static Node inorderSuccessor(Node node) {
      if (node == null) {
         return null;
      }

      if (node.right != null) {
         return leftMost(node.right);
      }

      Node parent = node.parent;
      while (parent != null && parent.left != node) {
         node = parent;
         parent = parent.parent;
      }

      return parent;
   }

   private static Node leftMost(Node node) {
      while (node.left != null) {
         node = node.left;
      }
      return node;
   }

   private static class Node {
      public int val;
      public Node left;
      public Node right;
      public Node parent;
   }
}
