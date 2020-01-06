package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/23/19.
 */
public class RemoveNthNodeFromEnd {
   private static class ListNode {
      int val;
      ListNode next;

      private ListNode(int x) {
         val = x;
      }
   }

   private static ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null) {
         return null;
      }

      ListNode dummy = new ListNode(0);
      ListNode slow = dummy;
      ListNode fast = dummy;
      slow.next = head;

      // move fast to nth position
      for (int i = 0 ; i<= n; i++) {
         fast = fast.next;
      }

      while (fast != null) {
         fast = fast.next;
         slow = slow.next;
      }

      slow.next = slow.next.next;

      return dummy.next;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode result = removeNthFromEnd(head, 2);
      while (result != null) {
         System.out.print(result.val);
         result = result.next;
         if (result != null) {
            System.out.print("->");
         }
      }
   }
}
