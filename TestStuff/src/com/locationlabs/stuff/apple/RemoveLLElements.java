package com.locationlabs.stuff.apple;

import com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class RemoveLLElements {

   private static ListNode removeElements(ListNode head, int val) {
      if (head == null) {
         return null;
      }

      while (head != null && head.val == val) {
         head = head.next;
      }

      ListNode dummy = head;
      while (dummy != null && dummy.next != null) {
         if (dummy.next.val == val) {
            dummy.next = dummy.next.next;
         } else {
            dummy = dummy.next;
         }
      }

      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(1);
      head.next.next = new ListNode(2);
      head.next.next.next = new ListNode(3);
      head.next.next.next.next = new ListNode(4);
      head.next.next.next.next.next = new ListNode(5);

      ListNode res = removeElements(head, 3);
      while (res != null) {
         System.out.print(res.val);
         if (res.next != null) {
            System.out.print("->");
         }
         res = res.next;
      }
   }
}
