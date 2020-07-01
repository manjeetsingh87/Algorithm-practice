package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class SerializeDeserializeBTree {
   // Encodes a tree to a single string.
   private static String serialize(TreeNode root) {
      if (root == null) {
         return "";
      }

      final StringBuilder sb = new StringBuilder();
      final String nullNode = "null";
      final Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
         final TreeNode curr = queue.poll();
         if (curr == null) {
            sb.append(nullNode).append(",");
            continue;
         }

         sb.append(curr.val).append(",");
         queue.offer(curr.left);
         queue.offer(curr.right);
      }

      return sb.toString();
   }

   // Decodes your encoded data to tree.
   private static TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) {
         return null;
      }

      final Queue<TreeNode> queue = new LinkedList<>();
      String[] values = data.split(",");
      final String nullNode = "null";
      TreeNode root = new TreeNode(Integer.parseInt(values[0]));

      queue.offer(root);

      for (int i = 1; i < values.length; i++) {
         final TreeNode parent = queue.poll();
         if (!values[i].equals(nullNode)) {
            final TreeNode left = new TreeNode(Integer.parseInt(values[i]));
            parent.left = left;
            queue.offer(left);
         }

         if (!values[++i].equals(nullNode)) {
            final TreeNode right = new TreeNode(Integer.parseInt(values[i]));
            parent.right = right;
            queue.offer(right);
         }
      }

      return root;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(5);
      final String data = serialize(root);
      System.out.println(data);

      final TreeNode node = deserialize(data);
      System.out.println(serialize(node));
   }
}
