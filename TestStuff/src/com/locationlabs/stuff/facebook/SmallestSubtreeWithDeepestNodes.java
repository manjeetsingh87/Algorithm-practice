package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import javafx.util.Pair;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class SmallestSubtreeWithDeepestNodes {
   private static TreeNode subtreeWithAllDeepest(TreeNode root) {
      if (root == null) {
         return null;
      }

      return getDeepestNode(root).getValue();
   }

   private static Pair<Integer, TreeNode> getDeepestNode(TreeNode node) {
      if (node == null) {
         return new Pair<>(0, null);
      }

      Pair<Integer, TreeNode> left = getDeepestNode(node.left);
      Pair<Integer, TreeNode> right = getDeepestNode(node.right);

      int leftDepth = left.getKey(), rightDepth = right.getKey();
      return new Pair<>(
              Math.max(leftDepth, rightDepth) + 1,
              leftDepth == rightDepth ? node : (leftDepth > rightDepth ? left.getValue() : right.getValue()));
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);
      root.right = new TreeNode(1);
      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);

      TreeNode deepest = subtreeWithAllDeepest(root);
      System.out.println(deepest);
   }
}
