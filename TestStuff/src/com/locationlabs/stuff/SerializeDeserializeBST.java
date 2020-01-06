package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/21/19.
 */
public class SerializeDeserializeBST {
   private static String serialize(TreeNode root) {
      if (root == null) {
         return null;
      }

      StringBuilder sb = new StringBuilder();

      final Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);

      while (!stack.isEmpty()) {
         final TreeNode curr = stack.pop();
         sb.append(curr.val).append(",");

         if (curr.right != null) {
            stack.push(curr.right);
         }
         if (curr.left != null) {
            stack.push(curr.left);
         }
      }

      return sb.toString();
   }

   // Decodes your encoded data to tree.
   private static TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) {
         return null;
      }

      String[] nodes = data.split(",");
      final Queue<Integer> queue = new LinkedList<>();
      for (String node : nodes) {
         queue.offer(Integer.parseInt(node));
      }

      return getNode(queue);
   }

   private static TreeNode getNode(Queue<Integer> queue) {
      if (queue == null || queue.isEmpty()) {
         return null;
      }

      final TreeNode node = new TreeNode(queue.poll());
      final Queue<Integer> leftChildren = new LinkedList<>();
      while (!queue.isEmpty() && (queue.peek() < node.val)) {
         leftChildren.offer(queue.poll());
      }
      node.left = getNode(leftChildren);
      node.right = getNode(queue);
      return node;
   }



   public static void main(String[] args) {
      TreeNode root = new TreeNode(40);
      root.left = new TreeNode(20);
      root.left.left = new TreeNode(10);
      root.left.right = new TreeNode(30);
      root.left.right.right = new TreeNode(35);

      root.right = new TreeNode(60);
      root.right.left = new TreeNode(50);
      root.right.right = new TreeNode(70);

      String serializedTree = serialize(root);
      System.out.println(serializedTree);

      TreeNode deserializedTree = deserialize(serializedTree);
      System.out.println(serialize(deserializedTree));
   }

}
