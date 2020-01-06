package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class LCA {
   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      int pVal = p.val;
      int qVal = q.val;

      while (root!= null) {
         if (pVal < root.val && qVal < root.val) {
            root = root.left;
         } else if (pVal > root.val && qVal > root.val) {
            root = root.right;
         } else {
            return root;
         }
      }
      return null;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.right = new TreeNode(1);

      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);

      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);

      TreeNode ans = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
      System.out.println(ans != null ? ans.val : null);

      ans = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
      System.out.println(ans != null ? ans.val : null);
   }
}
