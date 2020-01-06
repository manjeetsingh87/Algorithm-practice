package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class BTreePopulateNextRightPointer {
   private static Node connect(Node root) {
      if (root == null) {
         return root;
      }

      Node dummy = root;
      while (root.left != null) {
         Node temp = root;
         while (temp != null) {
            temp.left.next = temp.right;
            if (temp.next != null) {
               temp.right.next = temp.next.left;
            }
            temp = temp.next;
         }
         root = root.left;
      }
      return dummy;
   }

   // Definition for a Node.
   private class Node {
      public int val;
      public Node left;
      public Node right;
      public Node next;

      public Node() {}

      public Node(int _val,Node _left,Node _right,Node _next) {
         val = _val;
         left = _left;
         right = _right;
         next = _next;
      }
   };
}
