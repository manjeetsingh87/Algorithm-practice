package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class BSTFromPreorder {
   private static int index = 0;

   private static TreeNode bstFromPreorder(int[] preorder) {
      if (preorder == null || preorder.length == 0) {
         return null;
      }

      if (preorder.length == 1) {
         return new TreeNode(preorder[0]);
      }

      return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   private static TreeNode bstHelper(int[] preorder, int low, int high) {
      if (index < 0 || index >= preorder.length
              || preorder[index] < low || preorder[index] > high) {
         return null;
      }

      int val = preorder[index++];
      TreeNode node = new TreeNode(val);
      node.left = bstHelper(preorder, low, val);
      node.right = bstHelper(preorder, val, high);
      return node;
   }

   public static void main(String[] args) {
      TreeNode root = bstFromPreorder(new int[]{8,5,1,7,10,12});
      System.out.println(root);
   }
}
