package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by manjeet.singh on 5/28/19.
 */
public class BTreeRightSideView {
   private static List<Integer> rightSideView(TreeNode root) {
      final List<Integer> rightSideView = new ArrayList<>();
      if (root == null) {
         return rightSideView;
      }

      Deque<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         int size = queue.size();
         for (int i = 0; i < size; i++) {
            TreeNode current = queue.poll();
            if (i == 0) {
               rightSideView.add(current.val);
            }

            if (current.right != null) {
               queue.offer(current.right);
            }

            if (current.left != null) {
               queue.offer(current.left);
            }
         }
      }

      return rightSideView;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.right = new TreeNode(5);
      root.right.right = new TreeNode(4);
      System.out.println(rightSideView(root));
   }
}
