package com.locationlabs.stuff;

import com.locationlabs.stuff.ReverseLinkedList.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class MergeSortedLinkedLists {
   private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
      ListNode prev = result;

      while (l1 != null && l2 != null) {
         if (l1.val <= l2.val) {
            prev.next = l1;
            l1 = l1.next;
         } else {
            prev.next = l2;
            l2 = l2.next;
         }
         prev = prev.next;
      }

      if (l1 != null) {
         prev.next = l1;
      } else if (l2 != null) {
         prev.next = l2;
      }

      return result.next;
   }

   private static ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
      if (l1 == null) {
         return l2;
      } else if (l2 == null) {
         return l1;
      } else if (l1.val < l2.val) {
         l1.next = mergeTwoListsII(l1.next, l2);
         return l1;
      } else {
         l2.next = mergeTwoListsII(l1, l2.next);
         return l2;
      }
   }

   private static ListNode mergeKSortedLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
         return null;
      }

      final Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

      for (ListNode node : lists) {
         if (node != null) {
            minHeap.offer(node);
         }
      }

      ListNode result = new ListNode(0);
      ListNode temp = result;

      while (!minHeap.isEmpty()) {
         temp.next = minHeap.poll();
         temp = temp.next;

         if (temp.next != null) {
            minHeap.offer(temp.next);
         }
      }

      return result.next;
   }

   private static ListNode mergeKSortedListsII(ListNode[] lists) {
      int size = lists.length;

      if (size == 0) {
         return null;
      }

      if (size == 1) {
         return lists[0];
      }

      int mid = (size - 1) / 2;

      ListNode l1 = mergeKSortedListsII(Arrays.copyOfRange(lists, 0, mid + 1));
      ListNode l2 = mergeKSortedListsII(Arrays.copyOfRange(lists, mid + 1, size));

      return mergeTwoLists(l1, l2);
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(4);
      l1.next.next = new ListNode(7);

      ListNode l2 = new ListNode(2);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(5);

      //print(mergeKSortedLists(new ListNode[]{l1, l2}));
      print(mergeKSortedListsII(new ListNode[]{l1, l2}));
//      print(mergeTwoListsII(l1, l2));
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
