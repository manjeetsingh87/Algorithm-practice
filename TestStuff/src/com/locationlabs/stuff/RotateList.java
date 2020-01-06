package com.locationlabs.stuff;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;
/**
 * Created by manjeet.singh on 7/15/19.
 */
public class RotateList {
   private static ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode dummy = head;
      int len = 1;
      while (dummy.next != null) {
         dummy = dummy.next;
         len++;
      }

      dummy.next = head;
      k %= len;
      for (int i = 0; i < len - k; i++) {
         dummy = dummy.next;
      }

      head = dummy.next;
      dummy.next = null;

      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = null;

      ListNode newHead = rotateRight(head, 7);
      while (newHead != null) {
         System.out.print(newHead.val + "->");
         if (newHead.next == null) {
            System.out.print("NULL");
         }
         newHead = newHead.next;
      }
   }
}
