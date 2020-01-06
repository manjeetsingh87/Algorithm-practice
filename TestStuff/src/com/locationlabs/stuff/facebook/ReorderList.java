package com.locationlabs.stuff.facebook;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class ReorderList {
   private static void reorderList(ListNode head) {
      if (head == null || head.next == null) {
         return;
      }

      ListNode slow = head, fast = head, l1 = head;
      ListNode prev = null;
      while (fast != null && fast.next != null) {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
      }

      prev.next = null;

      ListNode l2 = reverse(slow);
      merge(l1, l2);
   }

   private static ListNode reverse(ListNode node) {
      ListNode prev = null, curr = node;
      while (curr != null) {
         ListNode temp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = temp;
      }
      return prev;
   }

   private static void merge(ListNode l1, ListNode l2) {
      while (l1 != null) {
         ListNode n1 = l1.next, n2 = l2.next;
         l1.next = l2;

         if (n1 == null) {
            break;
         }

         l2.next = n1;
         l1 = n1;
         l2 = n2;
      }
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      reorderList(head);

      while (head != null) {
         System.out.print(head.val + "->");
         head = head.next;
      }
   }
}
