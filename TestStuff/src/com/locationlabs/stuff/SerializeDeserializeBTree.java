package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
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
      final Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
         final TreeNode curr = stack.pop();
         if (curr == null) {
            sb.append(nullNode).append(",");
            continue;
         } else {
            sb.append(curr.val).append(",");
         }

         stack.push(curr.right);
         stack.push(curr.left);
      }

      return sb.toString();
   }

   // Decodes your encoded data to tree.
   private static TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) {
         return null;
      }

      final Deque<String> nodes = new LinkedList<>();
      nodes.addAll(Arrays.asList(data.split(",")));
      return deserializeBTree(nodes);
   }

   private static TreeNode deserializeBTree(Deque<String> nodes) {
      final String current = nodes.remove();
      if (current.equals("null")) {
         return null;
      }

      final TreeNode node = new TreeNode(Integer.parseInt(current));
      node.left = deserializeBTree(nodes);
      node.right = deserializeBTree(nodes);
      return node;
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
