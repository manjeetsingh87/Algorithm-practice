package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class BSTToSortedDLL {
   private Node first = null;
   private Node last = null;

   public Node treeToDoublyList(Node root) {
      if (root == null) {
         return root;
      }

      dfs(root);

      last.right = first;
      first.left = last;
      return first;
   }

   private void dfs(Node node) {
      if (node == null) {
         return;
      }

      dfs(node.left);

      if (last != null) {
         last.right = node;
         node.left = last;
      } else {
         first = node;
      }

      last = node;
      dfs(node.right);
   }

   private class Node {
      private int val;
      private Node left;
      private Node right;

      private Node() {}

      private Node(int _val,Node _left,Node _right) {
         val = _val;
         left = _left;
         right = _right;
      }
   }
}
