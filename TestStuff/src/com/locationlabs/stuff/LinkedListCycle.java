package com.locationlabs.stuff;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

public class LinkedListCycle {
   private static boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) {
         return false;
      }

      ListNode slow = head;
      ListNode fast = head;

      while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;

         if (slow == fast) {
            return true;
         }
      }

      return false;
   }

   private static ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null) {
         return null;
      }

      ListNode slow = head;
      ListNode fast = head;

      boolean isCycleFound = false;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;

         if (slow == fast) {
            isCycleFound = true;
            break;
         }
      }

      if (!isCycleFound) {
         return null;
      }

      ListNode temp = head;
      ListNode tempOther = slow;
      while (temp != slow) {
         temp = temp.next;
         tempOther = tempOther.next;
      }

      return tempOther;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(3);
      ListNode other = new ListNode(2);
      head.next = other;
      other.next = new ListNode(0);
      other.next.next = new ListNode(4);
      head.next.next.next.next = other;
      //System.out.println(hasCycle(head));

      ListNode cycleStart = detectCycle(head);
      System.out.println(cycleStart);
   }
}
