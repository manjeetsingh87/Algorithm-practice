package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class TwoSumBST {
   private static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
      if (root1 == null || root2 == null) {
         return false;
      }

      final Set<Integer> set = new HashSet<>();
      Stack<TreeNode> stack = new Stack<>();

      while(!stack.isEmpty() || root1 != null) {
         while (root1 != null) {
            stack.push(root1);
            root1 = root1.left;
         }

         final TreeNode node = stack.pop();
         set.add(target - node.val);
         root1 = node.right;
      }

      System.out.println(set);

      stack.clear();
      while (!stack.isEmpty() || root2 != null) {
         while (root2 != null) {
            stack.push(root2);
            root2 = root2.left;
         }

         final TreeNode node = stack.pop();
         if (set.contains(node.val)) {
            return true;
         }
         root2 = node.right;
      }

      return false;
   }

   private boolean twoSumBSTRec(TreeNode root1, TreeNode root2, int target) {
      if (root1 == null || root2 == null) {
         return false;
      }

      final Set<Integer> set = new HashSet<>();
      inorder(root1, set, target);

      return check(root2, set);
   }

   private void inorder(TreeNode node, final Set<Integer> set, final int target) {
      if (node == null) {
         return;
      }

      inorder(node.left, set, target);
      set.add(target - node.val);
      inorder(node.right, set, target);
   }

   private boolean check(TreeNode node, Set<Integer> set) {
      if (node == null) {
         return false;
      }

      return check(node.left, set) || set.contains(node.val) || check(node.right, set);
   }
}
