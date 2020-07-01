package com.locationlabs.stuff;

import java.util.List;

/**
 * Created by manjeet.singh on 3/27/19.
 */
public class ReverseLinkedList {
   public static class ListNode {
      public int val;
      public ListNode next;

      public ListNode(int x) {
         val = x;
      }
   }

   private static ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode current = head;

      while (current != null) {
         ListNode temp = current.next;
         current.next = prev;
         prev = current;
         current = temp;
      }

      return prev;
   }

   private static ListNode reverseListRecursive(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode newHead = reverseListRecursive(head.next);

      head.next.next = head;
      head.next = null;

      return newHead;
   }

   private static ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null || head.next == null || n <= m) {
         return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode curr = dummy;
      ListNode prev = null;

      for (int i = 0; i < m; i++) {
         prev = curr;
         curr = curr.next;
      }

      ListNode newCurr = curr;
      ListNode newPrev = prev;
      for (int i = m; i <= n; i++) {
         ListNode temp = newCurr.next;
         newCurr.next = newPrev;
         newPrev = newCurr;
         newCurr = temp;
      }

      prev.next = newPrev;
      curr.next = newCurr;

      return dummy;
   }

   private static ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || head.next == null || k <= 1) {
         return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode begin = dummy;
      int i = 0;
      while (head != null) {
         i++;
         if (i % k == 0) {
            begin = reverse(begin, head.next);
            head = begin.next;
         } else {
            head = head.next;
         }
      }

      return dummy.next;
   }

   private static ListNode reverse(ListNode begin, ListNode end) {
      ListNode curr = begin.next, prev = begin;
      ListNode first = curr;
      while (curr != end) {
         ListNode temp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = temp;
      }

      begin.next = prev;
      first.next = curr;
      return first;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      //ListNode result = reverseBetween(head, 2, 4);
      ListNode result = reverseKGroup(head, 2);
      while (result != null) {
         System.out.print(result.val);
         result = result.next;
         if (result != null) {
            System.out.print("->");
         }
      }
   }
}
