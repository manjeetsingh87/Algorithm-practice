package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class MinDepthOfBtree {
   private static int minDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int depth = 1;
      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         final int size = queue.size();
         for (int i = 0; i < size; i++) {
            final TreeNode curr = queue.poll();

            if (curr.left == null && curr.right == null) {
               return depth;
            }

            if (curr.left != null) {
               queue.offer(curr.left);
            }

            if (curr.right != null) {
               queue.offer(curr.right);
            }
         }

         depth++;
      }

      return depth;
   }
}
