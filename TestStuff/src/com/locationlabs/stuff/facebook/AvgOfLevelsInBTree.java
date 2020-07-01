package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.locationlabs.stuff.TreeNode;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class AvgOfLevelsInBTree {
   private static List<Double> averageOfLevels(TreeNode root) {
      if (root == null) {
         return null;
      }

      final List<Double> result = new ArrayList<>();
      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         final int size = queue.size();
         double levelSum = 0.0;
         for (int i = 0; i < size; i++) {
            final TreeNode curr = queue.poll();
            levelSum += curr.val;

            if (curr.left != null) {
               queue.offer(curr.left);
            }

            if (curr.right != null) {
               queue.offer(curr.right);
            }
         }

         result.add(levelSum / size);
      }

      return result;
   }
}
