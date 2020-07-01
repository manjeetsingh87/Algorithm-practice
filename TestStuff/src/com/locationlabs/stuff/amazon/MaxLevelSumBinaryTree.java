package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class MaxLevelSumBinaryTree {
   private static int maxLevelSum(TreeNode root) {
      if (root == null) {
         return 0;
      }

      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      int maxSumLevel = 0;
      int currentSumLevel = 0;
      int maxSum = 0;
      while (!queue.isEmpty()) {
         final int size = queue.size();
         currentSumLevel++;
         int currSum = 0;
         for (int i = 0; i < size; i++) {
            final TreeNode curr = queue.poll();
            currSum += curr.val;

            if (curr.left != null) {
               queue.offer(curr.left);
            }

            if (curr.right != null) {
               queue.offer(curr.right);
            }
         }

         if (currSum > maxSum) {
            maxSum = currSum;
            maxSumLevel = currentSumLevel;
         }
      }

      return maxSumLevel;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(7);
      root.right = new TreeNode(0);

      root.left.left = new TreeNode(7);
      root.left.right = new TreeNode(-8);

      System.out.println(maxLevelSum(root));
   }
}
