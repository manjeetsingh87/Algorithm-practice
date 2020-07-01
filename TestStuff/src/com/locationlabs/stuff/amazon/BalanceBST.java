package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 5/18/20.
 */
public class BalanceBST {
   private static TreeNode balanceBST(TreeNode root) {
      if (root == null) {
         return null;
      }

      final List<TreeNode> inorderList = new ArrayList<>();
      inorder(root, inorderList);
      return sortedArrayToBST(inorderList, 0, inorderList.size() - 1);
   }

   private static void inorder(TreeNode node, List<TreeNode> inorderList) {
      if (node == null) {
         return;
      }

      inorder(node.left, inorderList);
      inorderList.add(node);
      inorder(node.right, inorderList);
   }

   private static TreeNode sortedArrayToBST(List<TreeNode> inorderList, int left, int right) {
      if (left > right) {
         return null;
      }

      int mid = (left + right) / 2;
      final TreeNode root = inorderList.get(mid);
      root.left = sortedArrayToBST(inorderList, left, mid - 1);
      root.right = sortedArrayToBST(inorderList, mid + 1, right);

      return root;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(1);
      root.right = new TreeNode(2);
      root.right.right = new TreeNode(3);
      root.right.right.right = new TreeNode(4);

      final TreeNode result = balanceBST(root);
      System.out.println(result);
   }
}
