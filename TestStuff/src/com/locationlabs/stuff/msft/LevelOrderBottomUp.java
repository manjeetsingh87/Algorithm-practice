package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class LevelOrderBottomUp {
   private static List<List<Integer>> levelOrderBottom(TreeNode root) {
      final LinkedList<List<Integer>> result = new LinkedList<>();

      if (root == null) {
         return result;
      }

      final Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      List<Integer> levelValues;

      while (!queue.isEmpty()) {
         levelValues = new ArrayList<>();
         int size = queue.size();
         for (int i = 0; i < size; i++) {
            final TreeNode node = queue.poll();
            levelValues.add(node.val);

            if (node.left != null) {
               queue.offer(node.left);
            }

            if (node.right != null) {
               queue.offer(node.right);
            }
         }

         result.addFirst(levelValues);
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);

      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println(levelOrderBottom(root));
   }
}
