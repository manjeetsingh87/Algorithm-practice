package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class BTreeMaxWidth {

   private static class Node {
      private int index;
      private TreeNode node;

      protected Node(int index, TreeNode node) {
         this.index = index;
         this.node = node;
      }
   }

   private static int widthOfBinaryTree(TreeNode root) {
      if (root == null) {
         return 0;
      }

      final Queue<Node> queue = new LinkedList<>();
      queue.offer(new Node(0, root));
      int maxWidth = 0;

      while (!queue.isEmpty()) {
         final int size = queue.size();
         int start = 0, end = 0;
         for (int i = 0; i < size; i++) {
            final Node curr = queue.poll();
            final int currIdx = curr.index;
            final TreeNode currNode = curr.node;
            if (i == 0) {
               start = currIdx;
            }

            if (i == size - 1) {
               end = currIdx;
            }

            if (currNode.left != null) {
               queue.offer(new Node(2 * curr.index, currNode.left));
            }

            if (currNode.right != null) {
               queue.offer(new Node(2 * curr.index + 1, currNode.right));
            }
         }
         maxWidth = Math.max(maxWidth, (end - start) + 1);
      }

      return maxWidth;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(3);
      root.left.left= new TreeNode(5);
      root.left.left.left = new TreeNode(6);

      root.right = new TreeNode(2);
      root.right.right = new TreeNode(9);
      root.right.right.right = new TreeNode(7);

      System.out.println(widthOfBinaryTree(root));
   }
}
