package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class CountSmallerNumAfterSelf {
   private static List<Integer> countSmaller(int[] nums) {
      if (nums == null || nums.length == 0) {
         return new ArrayList<>();
      }

      final BST bst = new BST();
      final List<Integer> result = new ArrayList<>();

      for (int i = nums.length - 1; i >= 0; i--) {
         int count = bst.insert(nums[i]);
         result.add(count);
      }

      Collections.reverse(result);
      return result;
   }

   private static class TreeNode {
      TreeNode left;
      TreeNode right;
      int val;
      int count;

      public TreeNode(int val) {
         this.val = val;
         count = 1;
      }
   }

   private static class BST {
      private TreeNode root;

      private int insert(int key) {
         if (root == null) {
            root = new TreeNode(key);
            return 0;
         }

         TreeNode curr = root;
         int count = 0;
         while (true) {
            if (key <= curr.val) {
               curr.count++;
               if (curr.left == null) {
                  curr.left = new TreeNode(key);
                  break;
               }
               curr = curr.left;
            } else {
               count += curr.count;
               if (curr.right == null) {
                  curr.right = new TreeNode(key);
                  break;
               }
               curr = curr.right;
            }
         }

         return count;
      }
   }

   public static void main(String[] args) {
      System.out.println(countSmaller(new int[]{-1}));
      System.out.println(countSmaller(new int[]{5,2,6,1}));
   }
}