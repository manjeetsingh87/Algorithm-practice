package com.locationlabs.stuff;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;
/**
 * Created by manjeet.singh on 5/28/19.
 */
public class DeleteLinkedListNode {
   private static void deleteNode(ListNode node) {
      if (node.next == null) {
         node = node.next;
      } else {
         node.val = node.next.val;
         node.next = node.next.next;
      }
   }
}
