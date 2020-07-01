package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class TwoSumBST {
   private static boolean findTarget(TreeNode root, int k) {
      if (root == null) {
         return false;
      }

      final Set<Integer> set = new HashSet<>();
      final Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         final TreeNode curr = queue.poll();

         if (set.contains(k - curr.val)) {
            return true;
         }

         set.add(curr.val);

         if (curr.left != null) {
            queue.offer(curr.left);
         }

         if (curr.right != null) {
            queue.offer(curr.right);
         }
      }

      return false;
   }



   public static void main(String[] args) {
      final TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);

      root.right = new TreeNode(6);
      root.right.right = new TreeNode(24);

      System.out.println(findTarget(root, 9));
      System.out.println(findTarget(root, 28));
   }
}
