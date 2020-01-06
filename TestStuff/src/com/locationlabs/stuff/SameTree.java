package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class SameTree {
   private static boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
         return true;
      }

      if (p == null || q == null) {
         return false;
      }

      if (p.val != q.val) {
         return false;
      }

      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   }

   public static void main(String[] args) {
      TreeNode p = new TreeNode(1);
      p.left = new TreeNode(2);
      p.right = new TreeNode(3);

      TreeNode q = new TreeNode(1);
      q.left = new TreeNode(2);
      q.right = new TreeNode(3);

      System.out.println(isSameTree(p, q));

      p = new TreeNode(1);
      p.left = new TreeNode(2);

      q = new TreeNode(1);
      q.right = new TreeNode(2);

      System.out.println(isSameTree(p, q));
   }
}
