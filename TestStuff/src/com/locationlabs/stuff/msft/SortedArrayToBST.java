package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
/**
 * Created by manjeet.singh on 3/30/20.
 */
public class SortedArrayToBST {
   private static TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) {
         return null;
      }

      if (nums.length == 1) {
         return new TreeNode(nums[0]);
      }

      return helper(nums, 0, nums.length - 1);
   }

   private static TreeNode helper(int[] nums, int left, int right) {
      if (left > right) {
         return null;
      }

      int mid = (left + right) / 2;
      final TreeNode node = new TreeNode(nums[mid]);
      node.left = helper(nums, left, mid - 1);
      node.right = helper(nums, mid + 1, right);
      return node;
   }

   public static void main(String[] args) {
      final TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
      System.out.println(root);
   }
}
