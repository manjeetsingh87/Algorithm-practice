package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class BTreeBoundary {
   private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
      final List<Integer> result = new ArrayList<>();
      if (root == null) {
         return result;
      }

      result.add(root.val);
      if (root.left == null && root.right == null) {
         return result;
      }

      // left boundary
      if (root.left != null) {
         leftBoundary(root.left, result);
      }

      // leaf nodes
      leafNodes(root, result);

      // right boundary
      if (root.right != null) {
         rightBoundary(root.right, result);
      }

      return result;
   }

   private static void leftBoundary(TreeNode node, List<Integer> result) {
      // Populate parentNode value and then the childNode value
      if (node.left != null) {
         result.add(node.val);
         leftBoundary(node.left, result);
      } else if (node.right != null) { // If no left, pass right node to recursive call
         result.add(node.val);
         leftBoundary(node.right, result);
      }

   }

   private static void rightBoundary(TreeNode node, List<Integer> result) {
      // Right boundary values -  child node value before parent node value
      if (node.right != null) {
         rightBoundary(node.right, result);
         result.add(node.val);
      } else if (node.left != null) {
         rightBoundary(node.left, result);
         result.add(node.val);
      }
   }

   private static void leafNodes(TreeNode node, List<Integer> result) {
      // Populate result only if it is a leaf node (No child nodes)
      if (node.left == null && node.right == null) {
         result.add(node.val);
         return;
      }

      if (node.left != null) {
         leafNodes(node.left, result);
      }

      if (node.right != null) {
         leafNodes(node.right, result);
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(8);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(6);
      root.right.left.left = new TreeNode(9);
      root.right.left.right = new TreeNode(10);
      System.out.println(boundaryOfBinaryTree(root));
   }
}
