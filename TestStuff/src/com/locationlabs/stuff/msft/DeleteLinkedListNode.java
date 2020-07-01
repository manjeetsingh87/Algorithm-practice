package com.locationlabs.stuff.msft;

import static com.locationlabs.stuff.ReverseLinkedList.ListNode;
/**
 * Created by manjeet.singh on 3/30/20.
 */
public class DeleteLinkedListNode {
   private void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
   }
}
