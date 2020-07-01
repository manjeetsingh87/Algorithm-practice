package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class PartitionList {
   private static ListNode partition(ListNode head, int x) {
      if (head == null) {
         return null;
      }

      ListNode beforeHead = new ListNode(0);
      ListNode before = beforeHead;

      ListNode afterHead = new ListNode(0);
      ListNode after = afterHead;

      while (head != null) {
         if (head.val < x) {
            before.next = head;
            before = before.next;
         } else {
            after.next = head;
            after = after.next;
         }
         head = head.next;
      }

      after.next = null;

      before.next = afterHead.next;

      return beforeHead.next;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(4);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(2);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(2);

      ListNode result = partition(head, 3);
      while (result != null) {
         System.out.print(result.val);
         if (result.next != null) {
            System.out.print("->");
         }
         result = result.next;
      }
   }
}
