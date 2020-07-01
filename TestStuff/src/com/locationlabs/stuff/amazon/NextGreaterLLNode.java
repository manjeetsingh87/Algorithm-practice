package com.locationlabs.stuff.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

/**
 * Created by manjeet.singh on 5/12/20.
 */
public class NextGreaterLLNode {
   private static int[] nextLargerNodes(ListNode head) {
      if (head == null) {
         return new int[0];
      }

      final Integer[] arr = listToArray(head);
      final int[] result = new int[arr.length];
      final Deque<Integer> stack = new ArrayDeque<>();

      for (int i = 0; i < arr.length; i++) {
         while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
            result[stack.pop()] = arr[i];
         }
         stack.push(i);
      }

      return result;
   }

   private static Integer[] listToArray(ListNode head) {
      final List<Integer> list = new ArrayList<>();
      ListNode node = head;
      while (node != null) {
         list.add(node.val);
         node = node.next;
      }

      return list.toArray(new Integer[0]);
   }

   public static void main(String[] args) {
      final ListNode head = new ListNode(1);
      head.next = new ListNode(7);
      head.next.next = new ListNode(5);
      head.next.next.next = new ListNode(1);
      head.next.next.next.next = new ListNode(9);
      head.next.next.next.next.next = new ListNode(2);
      head.next.next.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next.next.next = new ListNode(1);
      System.out.println(Arrays.toString(nextLargerNodes(head)));
   }
}
