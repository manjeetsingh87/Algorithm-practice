package com.locationlabs.stuff.dropbox;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class AddTwoNumbers {
   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
         return null;
      }

      if (l1 == null) {
         return l2;
      }

      if (l2 == null) {
         return l1;
      }

      ListNode result = new ListNode(0);
      ListNode current = result;
      int carry = 0;

      while (l1 != null || l2 != null || carry != 0) {
         int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

         ListNode temp = new ListNode(sum % 10);
         current.next = temp;
         current = temp;

         carry = sum / 10;

         l1 = l1 == null ? null : l1.next;
         l2 = l2 == null ? null : l2.next;
      }

      return result.next;
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(8);

      ListNode l2 = new ListNode(0);

      ListNode result = addTwoNumbers(l1, l2);
      while (result != null) {
         System.out.print(result.val);
         System.out.print(result.next != null ? "->" : "");
         result = result.next;
      }
   }

   protected static class ListNode {
      int val;
      ListNode next;

      protected ListNode(int val) {
         this.val = val;
      }
   }
}
