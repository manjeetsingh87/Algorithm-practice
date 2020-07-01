package com.locationlabs.stuff.apple;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 6/9/20.
 */
public class MergeTwoBinaryTrees {
   private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      if (t1 == null && t2 == null) {
         return null;
      }

      if (t1 == null) {
         return t2;
      }

      if (t2 == null) {
         return t1;
      }

      final int val = t1.val + t2.val;
      final TreeNode curr = new TreeNode(val);

      curr.left = mergeTrees(t1.left, t2.left);
      curr.right = mergeTrees(t1.right, t2.right);

      return curr;
   }


}
