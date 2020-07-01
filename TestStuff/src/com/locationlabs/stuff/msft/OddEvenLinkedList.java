package com.locationlabs.stuff.msft;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 4/6/20.
 */
public class OddEvenLinkedList {
   private static ListNode oddEvenList(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode oddHead = head, evenHead = head.next, evenDummy = evenHead;

      while (evenHead != null && evenHead.next != null) {
         oddHead.next = evenHead.next;
         oddHead = oddHead.next;

         evenHead.next = oddHead.next;
         evenHead = evenHead.next;
      }

      oddHead.next = evenDummy;

      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(2);
      head.next = new ListNode(1);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(5);
      head.next.next.next.next = new ListNode(6);
      head.next.next.next.next.next = new ListNode(4);
      head.next.next.next.next.next.next = new ListNode(7);

      ListNode result = oddEvenList(head);
      while (result != null) {
         System.out.print(result.val);
         if (result.next != null) {
            System.out.print("->");
         }
         result = result.next;
      }
   }
}
