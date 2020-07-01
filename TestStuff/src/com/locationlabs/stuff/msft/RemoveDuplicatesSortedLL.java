package com.locationlabs.stuff.msft;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 4/13/20.
 */
public class RemoveDuplicatesSortedLL {
   private static ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      //use two pointers, slow - track the node before the dup nodes,
      // fast - to find the last node of dups.
      ListNode dummy = new ListNode(0);
      ListNode fast = head, slow = dummy;
      slow.next = fast;

      while (fast != null) {
         //while loop to find the last node of the dups.
         while (fast.next != null && fast.next.val == fast.val) {
            fast = fast.next;
         }

         if (slow.next != fast) { // found duplicate
            slow.next = fast.next; // remove the duplicate node
            fast = slow.next; // reorder fast to it's correct position
         } else { //no dup, move down both pointer.
            slow = slow.next;
            fast = fast.next;
         }
      }

      return dummy.next;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(3);
      head.next.next.next.next = new ListNode(4);
      head.next.next.next.next.next = new ListNode(4);
      head.next.next.next.next.next.next = new ListNode(5);

      ListNode result = deleteDuplicates(head);
      print(result);

      head = new ListNode(1);
      head.next = new ListNode(1);
      head.next.next = new ListNode(1);
      head.next.next.next = new ListNode(2);
      head.next.next.next.next = new ListNode(3);
      result = deleteDuplicates(head);
      print(result);
   }

   private static void print(ListNode node) {
      while (node != null) {
         System.out.print(node.val);
         if (node.next != null) {
            System.out.print("->");
         }
         node = node.next;
      }
      System.out.println("\n---------------------------\n");
   }
}
