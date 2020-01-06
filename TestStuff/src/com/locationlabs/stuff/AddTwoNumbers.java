package com.locationlabs.stuff;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result = new ListNode(0);
      ListNode current = result;
      int carry = 0;
      while (l1 != null || l2 != null || carry != 0) {
         int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
         ListNode temp = new ListNode(sum%10);
         carry = sum/10;
         current.next = temp;
         current = temp;

         l1 = (l1 == null) ? null : l1.next;
         l2 = (l2 == null) ? null : l2.next;
      }
      return result.next;
   }

   private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(2);
      l1.next = new ListNode(4);
      l1.next.next = new ListNode(3);

      ListNode l2 = new ListNode(5);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(4);

      ListNode result = addTwoNumbers(l1, l2);

      String res = "";
      while(result != null) {
         res = res + String.valueOf(result.val);

         if (result.next != null) {
            res = res + "->";
         }
         result = result.next;
      }
      System.out.println(res);
   }
}
