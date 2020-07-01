package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class AllElementsInTwoBST {
   private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

      final Queue<Integer> q1 = new LinkedList<>();
      final Queue<Integer> q2 = new LinkedList<>();

      inorder(root1, q1);
      inorder(root2, q2);

      final List<Integer> result = new ArrayList<>();
      while (!q1.isEmpty() || !q2.isEmpty()) {
         if (q1.isEmpty()) {
            result.add(q2.poll());
         } else if (q2.isEmpty()) {
            result.add(q1.poll());
         } else {
            result.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());
         }
      }

      return result;
   }

   private static void inorder(TreeNode node, Queue<Integer> queue) {
      if (node == null) {
         return;
      }

      inorder(node.left, queue);
      queue.offer(node.val);
      inorder(node.right, queue);
   }

   public static void main(String[] args) {
      TreeNode root1 = new TreeNode(2);
      root1.left = new TreeNode(1);
      root1.right = new TreeNode(4);

      TreeNode root2 = new TreeNode(1);
      root2.left = new TreeNode(0);
      root2.right = new TreeNode(3);

      System.out.println(getAllElements(root1, root2));
   }
}
