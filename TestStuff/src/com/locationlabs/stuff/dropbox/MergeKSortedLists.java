package com.locationlabs.stuff.dropbox;

import static com.locationlabs.stuff.dropbox.AddTwoNumbers.ListNode;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class MergeKSortedLists {
   private static ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
         return null;
      }

      int size = lists.length;
      if (size == 1) {
         return lists[0];
      }

      int mid = (size - 1) / 2;
      ListNode l1 = mergeKLists(Arrays.copyOfRange(lists, 0, mid + 1));
      ListNode l2 = mergeKLists(Arrays.copyOfRange(lists, mid + 1, size));

      return mergeTwoSortedLists(l1, l2);
   }

   private static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
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
      while (l1 != null && l2 != null) {
         if (l1.val < l2.val) {
            current.next = l1;
            l1 = l1.next;
         } else {
            current.next = l2;
            l2 = l2.next;
         }
         current = current.next;
      }

      if (l1 != null) {
         current.next = l1;
      } else if (l2 != null) {
         current.next = l2;
      }

      return result.next;
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(4);
      l1.next.next = new ListNode(7);

      ListNode l2 = new ListNode(2);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(5);

      print(mergeKLists(new ListNode[]{l1, l2}));
   }

   private static void print(ListNode result) {
      while (result != null) {
         System.out.print(result.val);
         if (result.next != null) {
            System.out.print("->");
         }
         result = result.next;
      }
   }
}
