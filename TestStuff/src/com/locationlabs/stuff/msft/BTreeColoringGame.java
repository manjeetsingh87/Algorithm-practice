package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class BTreeColoringGame {
   private static int leftCount, rightCount;

   private static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
      count(root, x);
      return Math.max(Math.max(leftCount, rightCount), n - (leftCount + rightCount + 1)) > (n / 2);
   }

   private static int count(TreeNode node, int x) {
      if (node == null) {
         return 0;
      }

      int left = count(node.left, x);
      int right = count(node.right, x);

      if (node.val == x) {
         leftCount = left;
         rightCount = right;
      }

      return left + right + 1;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);
      root.left.left.left = new TreeNode(8);
      root.left.left.right = new TreeNode(9);
      root.left.right.left = new TreeNode(10);
      root.left.right.right = new TreeNode(11);

      System.out.println(btreeGameWinningMove(root, 11, 2));
   }
}
