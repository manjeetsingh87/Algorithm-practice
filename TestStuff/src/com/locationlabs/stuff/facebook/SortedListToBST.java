package com.locationlabs.stuff.facebook;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;

import com.locationlabs.stuff.BTreeInorder;
import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class SortedListToBST {
   private static TreeNode sortedListToBST(ListNode head) {
      if (head == null) {
         return null;
      }

      return toBST(head, null);
   }

   private static TreeNode toBST(ListNode head, ListNode tail) {
      ListNode slow = head, fast = head;
      if (head == tail) {
         return null;
      }

      while (fast != tail && fast.next != tail) {
         fast = fast.next.next;
         slow = slow.next;
      }

      TreeNode curr = new TreeNode(slow.val);
      curr.left = toBST(head, slow);
      curr.right = toBST(slow.next, tail);
      return curr;
   }

   public static void main(String[] args) {
      final ListNode head = new ListNode(-10);
      head.next = new ListNode(-3);
      head.next.next = new ListNode(0);
      head.next.next.next = new ListNode(5);
      head.next.next.next.next = new ListNode(9);

      TreeNode root = sortedListToBST(head);
      System.out.println(root);
   }
}
