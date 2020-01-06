package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/2/19.
 */
public class LevelOrderTraversal {
   private static List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();

      if (root == null) {
         return result;
      }

      boolean evenLevel = true;
      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         final int level = queue.size();
         List<Integer> levelValues = new ArrayList<>();
         for (int i = 0; i < level; i++) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
               queue.offer(curr.left);
            }

            if (curr.right != null) {
               queue.offer(curr.right);
            }

            if (!evenLevel) {
               levelValues.add(0, curr.val);
            } else {
               levelValues.add(curr.val);
            }
         }

         evenLevel = !evenLevel;
         result.add(levelValues);
      }

      return result;
   }

   private static List<List<Integer>> levelOrderBotton(TreeNode root) {
      LinkedList<List<Integer>> result = new LinkedList<>();

      if (root == null) {
         return result;
      }

      final Deque<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      List<Integer> levelValues;

      while (!queue.isEmpty()) {
         levelValues = new ArrayList<>();
         final int size = queue.size();
         for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            levelValues.add(curr.val);

            if (curr.left != null) {
               queue.offer(curr.left);
            }

            if (curr.right != null) {
               queue.offer(curr.right);
            }
         }
         result.addFirst(levelValues);
      }

      return result;
   }

   private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      dfsHelper(result, root, 0);
      return result;
   }

   private static void dfsHelper(List<List<Integer>> result, TreeNode node, int level) {
      if (node == null) {
         return;
      }

      //initialize list at current level
      if (result.size() <= level) {
         result.add(new ArrayList<>());
      }

      List<Integer> currentLevel = result.get(level);
      if (level % 2 == 0) {
         currentLevel.add(node.val);
      } else {
         currentLevel.add(0, node.val);
      }
      dfsHelper(result, node.left, level + 1);
      dfsHelper(result, node.right, level + 1);
   }


   public static void main(String[] args) {
//      TreeNode root = new TreeNode(1);
//      root.left = new TreeNode(3);
//      root.right = new TreeNode(2);
//
//      root.left.left = new TreeNode(5);
//      root.left.right = new TreeNode(3);
//
//      root.right.right = new TreeNode(9);
//
//      System.out.println(levelOrder(root));

      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);

      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      /*System.out.println(levelOrder(root));
      System.out.println(levelOrderTraversal(root));*/
      System.out.println(levelOrderBotton(root));
   }
}
