package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by manjeet.singh on 7/26/19.
 */
public class BTreeRightSideView {
   private static List<Integer> rightSideView(TreeNode root) {
      final List<Integer> result = new ArrayList<>();
      if (root == null) {
         return result;
      }

      final Deque<TreeNode> treeQueue = new LinkedList<>();
      treeQueue.offer(root);

      while (!treeQueue.isEmpty()) {
         int currentSize = treeQueue.size();
         for (int i = 0; i < currentSize; i++) {
            final TreeNode current = treeQueue.poll();

            if (i == currentSize - 1) {
               result.add(current.val);
            }

            if (current.left != null) {
               treeQueue.offer(current.left);
            }

            if (current.right != null) {
               treeQueue.offer(current.right);
            }


         }
      }

      return result;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.right = new TreeNode(5);

      root.right = new TreeNode(3);
      root.right.right = new TreeNode(4);
      System.out.println(rightSideView(root));
   }
}
