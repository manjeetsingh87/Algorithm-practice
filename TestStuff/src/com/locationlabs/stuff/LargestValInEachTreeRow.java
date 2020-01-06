package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/1/19.
 */
public class LargestValInEachTreeRow {
   private static List<Integer> largestValues(TreeNode root) {
      if (root == null) {
         return null;
      }

      final List<Integer> result = new ArrayList<>();
      final Queue<TreeNode> queue = new LinkedList<>();

      queue.offer(root);

      while (!queue.isEmpty()) {
         int size = queue.size();

         int maxVal = Integer.MIN_VALUE;
         for(int i = 0; i < size; i++) {
            TreeNode current = queue.poll();
            maxVal = Math.max(maxVal, current.val);

            if(current.left != null) {
               queue.offer(current.left);
            }

            if (current.right != null) {
               queue.offer(current.right);
            }
         }
         result.add(maxVal);
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.right = new TreeNode(2);

      root.left.left = new TreeNode(5);
      root.left.right = new TreeNode(3);

      root.right.right = new TreeNode(9);

      System.out.println(largestValues(root));
   }
}
