package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class SubTreeOfAnotherTree {
   private static boolean isSubtree(TreeNode s, TreeNode t) {
      if (s == null) {
         return t == null;
      }

      if (isSameTree(s, t)) {
         return true;
      }

      return isSubtree(s.left, t) || isSubtree(s.right, t);
   }

   private static boolean isSameTree(TreeNode s, TreeNode t) {
      if (s == null && t == null) {
         return true;
      }

      if (s == null || t == null) {
         return false;
      }

      if (s.val != t.val) {
         return false;
      }

      return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
   }
}
