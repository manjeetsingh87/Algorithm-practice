package com.locationlabs.stuff.facebook;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;
/**
 * Created by manjeet.singh on 8/6/19.
 */
public class PalindromeLinkedList {
   private static boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
         return true;
      }

      ListNode dummy = head, fast = head;
      while (fast != null && fast.next != null) {
         fast = fast.next.next;
         dummy = dummy.next;
      }

      if (fast != null) {
         dummy = dummy.next;
      }

      fast = head;
      dummy = reverse(dummy);

      while (dummy != null) {
         if (dummy.val != fast.val) {
            return false;
         }
         fast = fast.next;
         dummy = dummy.next;
      }

      return true;
   }

   private static ListNode reverse(ListNode node) {
      ListNode prev = null;
      while (node != null) {
         ListNode temp = node.next;
         node.next = prev;
         prev = node;
         node = temp;
      }
      return prev;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(1);
      /*head.next.next.next = new ListNode(1);*/
      System.out.println(isPalindrome(head));
   }
}
