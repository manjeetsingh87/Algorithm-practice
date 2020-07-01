package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.ReverseLinkedList;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class SwapNodesInPairs {

   // recursive solution
   private static ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode next = head.next;
      head.next = swapPairs(head.next.next);
      next.next = head;
      return next;
   }

   private static ListNode swapNodePairs(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode curr = dummy;

      while (curr.next != null && curr.next.next != null) {
         ListNode first = curr.next;
         ListNode second = curr.next.next;

         first.next = second.next;
         curr.next = second;
         curr.next.next = first;
         curr = curr.next.next;
      }

      return dummy.next;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode result = swapPairs(head);
      printLL(result);

      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      head2.next.next.next.next = new ListNode(5);
      ListNode result2 = swapNodePairs(head2);
      printLL(result2);
   }

   private static void printLL(ListNode result) {
      while (result != null) {
         System.out.print(result.val);
         if (result.next != null) {
            System.out.print("->");
         }
         result = result.next;
      }
      System.out.println("\n");
   }
}
