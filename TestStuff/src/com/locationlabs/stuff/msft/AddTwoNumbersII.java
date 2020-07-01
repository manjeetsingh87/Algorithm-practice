package com.locationlabs.stuff.msft;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 4/6/20.
 */
public class AddTwoNumbersII {
   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
         return l1;
      }

      if (l1 == null) {
         return l2;
      }

      if (l2 == null) {
         return l1;
      }

      final Deque<Integer> l1Stack = new ArrayDeque<>();
      final Deque<Integer> l2Stack = new ArrayDeque<>();

      while (l1 != null) {
         l1Stack.push(l1.val);
         l1 = l1.next;
      }

      while (l2 != null) {
         l2Stack.push(l2.val);
         l2 = l2.next;
      }

      int carry = 0;
      ListNode dummy = null;

      while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
         final int l1Val = l1Stack.isEmpty() ? 0 : l1Stack.pop();
         final int l2Val = l2Stack.isEmpty() ? 0 : l2Stack.pop();

         final int currSum = l1Val + l2Val +  carry;

         final ListNode currHead = new ListNode(currSum % 10);
         currHead.next = dummy;
         dummy = currHead;
         carry = currSum / 10;
      }

      if (carry != 0) {
         final ListNode newDummy = new ListNode(carry);
         newDummy.next = dummy;
         dummy = newDummy;
      }

      return dummy;
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(7);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(4);
      l1.next.next.next = new ListNode(3);

      ListNode l2 = new ListNode(5);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(4);

      ListNode result = addTwoNumbers(l1, l2);
      while (result != null) {
         System.out.print(result.val);
         if (result.next != null) {
            System.out.print("->");
         }
         result = result.next;
      }
   }
}
