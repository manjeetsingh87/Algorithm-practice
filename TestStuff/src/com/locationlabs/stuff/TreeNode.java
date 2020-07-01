package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int x) { val = x; }

   @Override
   public String toString() {
      return "" + val;
   }
}
