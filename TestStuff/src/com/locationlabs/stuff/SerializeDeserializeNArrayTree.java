package com.locationlabs.stuff;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class SerializeDeserializeNArrayTree {
   private static String serialize(Node root) {
      if (root == null) {
         return null;
      }

      final StringBuilder sb = new StringBuilder();
      sHelper(root, sb);
      return sb.toString();
   }

   private static void sHelper(Node node, StringBuilder sb) {
      if (node == null) {
         return;
      }

      sb.append(node.val).append(" ");
      if (node.children != null && !node.children.isEmpty()) {
         sb.append("[").append(" ");
         for (Node child : node.children) {
            sHelper(child, sb);
         }
         sb.append("]").append(" ");
      }
   }

   // Decodes your encoded data to tree.
   private static Node deserialize(String data) {
      if (data == null || data.isEmpty()) {
         return null;
      }

      String[] nodes = data.trim().split("\\s");
      final Deque<Node> stack = new ArrayDeque<>();
      Node root = new Node(Integer.parseInt(nodes[0]), new ArrayList<Node>());
      Node current = root;
      for (int i = 1; i < nodes.length; i++) {
         if (nodes[i].equals("[")) {
            stack.push(current);
         } else if (nodes[i].equals("]")) {
            stack.pop();
         } else {
            current = new Node(Integer.parseInt(nodes[i]), new ArrayList<>());
            stack.peek().children.add(current);
         }
      }

      return root;
   }

   public static void main(String[] args) {
      Node root = new Node(
              1,  Arrays.asList(new Node(3, Arrays.asList(new Node(5, null), new Node(6, null))),
                                new Node(2, null),
                                new Node(4, null)));
      String data = serialize(root);
      System.out.println(data);
      Node node = deserialize(data);
      System.out.println(serialize(node));
   }

   private static class Node {
      private int val;
      private List<Node> children;

      private Node(int val, List<Node> children) {
         this.val = val;
         this.children = children;
      }
   }
}
