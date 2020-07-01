package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class NextRightPointerToEachNodeII {
   // Definition for a Node.
   class Node {
      public int val;
      public Node left;
      public Node right;
      public Node next;

      public Node() {}

      public Node(int _val) {
         val = _val;
      }

      public Node(int _val, Node _left, Node _right, Node _next) {
         val = _val;
         left = _left;
         right = _right;
         next = _next;
      }
   }

   private static Node connect(Node root) {
      if (root == null) {
         return null;
      }
      Node head = root;
      Node curr = null, prev = null;

      while (head != null) {

         // explore current level
         while (head != null) {
            // left child
            if (head.left != null) {
               if (prev != null) {
                  prev.next = head.left;
               } else {
                  curr = head.left;
               }

               // set pointer correctly
               prev = head.left;
            }

            // right child
            if (head.right != null) {
               if (prev != null) {
                  prev.next = head.right;
               } else {
                  curr = head.right;
               }

               // set pointer correctly
               prev = head.right;
            }

            //move to next node
            head = head.next;
         }

         // done exploring all nodes at this level, move to the next level
         head = curr;
         curr = null;
         prev = null;
      }

      return root;
   }
}
