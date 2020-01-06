package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/25/19.
 */
public class DeepCopyLinkedList {
   private static class Node {
      private int val;
      private Node next;
      private Node random;

      // default constructor
      public Node() {

      }

      public Node(int val,Node next, Node random) {
         this.val = val;
         this.next = next;
         this.random = random;
      }
   }
   private static Node copyRandomList(Node head) {
      if (head == null) {
         return null;
      }

      Node current = head;
      while (current != null) {
         Node dup = current.next;
         current.next = new Node(current.val, dup, null);
         current =  dup;
      }

      current = head;
      while (current != null) {
         if (current.random != null) {
            current.next.random = current.random.next ;
         }
         current = current.next.next;
      }

      current = head;
      Node copyList = head.next;
      while (current != null) {
         Node next = current.next.next;
         Node copy = current.next;
         current.next = next;
         if (next != null) {
            copy.next = next.next;
         }
         current = next;
      }

      return copyList;
   }

   public static void main(String[] args) {
      Node n4 = new Node(4, null, null);
      Node n3 = new Node(3, n4, null);
      Node n2 = new Node(2, n3, n4);
      Node head = new Node(1, n2, n3);

      Node head2 = copyRandomList(head);
      print(head2);
   }

   private static void print(Node node) {
      while (node != null) {
         System.out.print(node.val);
         if (node.random != null) {
            System.out.print("#");
            System.out.print(node.random.val);
            System.out.print("#");
         }
         if (node.next != null) {
            System.out.print("->");
         }
         node = node.next;
      }
   }
}
