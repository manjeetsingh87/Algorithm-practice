package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 3/31/20.
 */

public class TrimBST {
   private static TreeNode trimBST(TreeNode root, int L, int R) {
      if (root == null) {
         return null;
      }

      if (root.val < L) {
         return trimBST(root.right, L, R);
      }

      if (root.val > R) {
         return trimBST(root.left, L, R);
      }

      root.left = trimBST(root.left, L, R);
      root.right = trimBST(root.right, L, R);
      return root;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(3);
      root.left = new TreeNode(0);
      root.left.right = new TreeNode(2);
      root.left.right.left = new TreeNode(1);
      root.right = new TreeNode(4);

      final TreeNode result = trimBST(root, 1, 3);
      System.out.println(result);
   }
}
