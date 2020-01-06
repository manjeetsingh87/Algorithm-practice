package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/29/19.
 */
public class SortedArrayToBST {
   private static TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null || nums.length == 0) {
         return null;
      }
      return helper(nums, 0, nums.length-1);
   }

   private static TreeNode helper(int[] nums, int low, int high) {
      if (low > high) {
         return null;
      }

      int mid = (low + high) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      root.left = helper(nums, low, mid - 1);
      root.right = helper(nums, mid + 1, high);
      return root;
   }

   public static void main(String[] args) {
      TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
      System.out.println(root);
   }
}
