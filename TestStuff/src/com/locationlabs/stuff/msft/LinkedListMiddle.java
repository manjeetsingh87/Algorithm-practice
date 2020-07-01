package com.locationlabs.stuff.msft;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class LinkedListMiddle {
   private static ListNode middleNode(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode slow = head, fast = head;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      return slow;
   }

   private static void printList(ListNode node) {
      while (node != null) {
         System.out.print(node.val);
         if (node.next != null) {
            System.out.print("->");
         }
         node = node.next;
      }
      System.out.println("\n---------------------------------");
   }

   public static void main(String[] args) {
      ListNode head1 = new ListNode(1);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(3);
      head1.next.next.next = new ListNode(4);
      head1.next.next.next.next = new ListNode(5);

      printList(middleNode(head1));

      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      head2.next.next.next.next = new ListNode(5);
      head2.next.next.next.next.next = new ListNode(6);

      printList(middleNode(head2));
   }
}
