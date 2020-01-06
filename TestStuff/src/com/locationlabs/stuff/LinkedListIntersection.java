package com.locationlabs.stuff;

import com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class LinkedListIntersection {
   private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) {
         return null;
      }

      ListNode tempA = headA;
      ListNode tempB = headB;

      while (tempA != tempB) {
         tempA = tempA == null ? headB : tempA.next;
         tempB = tempB == null ? headA : tempB.next;
      }
      return tempA;
   }

   public static void main(String[] args) {
      ListNode headA = new ListNode(4);
      headA.next = new ListNode(1);

      ListNode common = new ListNode(8);
      common.next = new ListNode(4);
      common.next.next = new ListNode(8);

      ListNode headB = new ListNode(5);
      headB.next = new ListNode(0);
      headB.next.next = new ListNode(1);

      headA.next.next = common;
      headB.next.next.next = common;

      print(getIntersectionNode(headA, headB));


      headA = new ListNode(2);
      headA.next = new ListNode(6);
      headA.next.next = new ListNode(4);

      headB = new ListNode(1);
      headB.next = new ListNode(5);

      print(getIntersectionNode(headA, headB));
   }

   private static void print(ListNode result) {
      System.out.println(result == null ? 0 : result.val);
   }
}
