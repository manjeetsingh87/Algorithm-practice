package com.locationlabs.stuff.msft;

import java.util.Stack;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class FlattenMultiLevelDoublyLL {
   class Node {
      private int val;
      private Node prev;
      private Node next;
      private Node child;

      public Node() {}

      public Node(int _val,Node _prev,Node _next,Node _child) {
         this.val = _val;
         this.prev = _prev;
         this.next = _next;
         this.child = _child;
      }
   };

   private Node flatten(Node head) {
      if (head == null) {
         return null;
      }

      Node current = head;
      final Stack<Node> stack = new Stack<>();
      while (current != null) {
         if (current.child != null) {
            // if the current node has a child, then add the next node to the stack
            stack.push(current.next);
            current.next = current.child;
            current.child = null;
         }

         // determine the next node in the list.
         Node next = (current.next == null && !stack.isEmpty()) ? stack.pop() : current.next;

         if (next != null) {
            // adjust all pointers
            next.prev = current;
            current.next = next;
         }

         current = next;
      }

      return head;
   }
}
