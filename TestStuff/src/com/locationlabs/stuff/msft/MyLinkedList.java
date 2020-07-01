package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/7/20.
 */
public class MyLinkedList {
   private class Node {
      int val;
      Node next;

      // default constructor
      Node () {

      }

      // overloaded constructor
      Node(int val) {
         this.val = val;
      }
   }

   private int size;
   private Node head;
   private Node tail;

   /** Initialize your data structure here. */
   public MyLinkedList() {
      size = 0;
      head = new Node();
      tail = head;
   }

   /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
   public int get(int index) {
      if (index < 0 || index >= size) {
         return -1;
      }

      return findPrev(index).next.val;
   }

   /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
   public void addAtHead(int val) {
      if (size == 0) {
         addAtTail(val);
      } else {
         addAfter(head, val);
      }
   }

   /** Append a node of value val to the last element of the linked list. */
   public void addAtTail(int val) {
      addAfter(tail, val);
      tail = tail.next;
   }

   /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
   public void addAtIndex(int index, int val) {
      if (index > size) {
         return;
      }

      if (index <= 0) {
         addAtHead(val);
         return;
      }

      if (index == size) {
         addAtTail(val);
         return;
      }

      addAfter(findPrev(index), val);
   }

   /** Delete the index-th node in the linked list, if the index is valid. */
   public void deleteAtIndex(int index) {
      if (index < 0 || index >= size) {
         return;
      }

      Node prev = findPrev(index);
      if (index == size - 1) {
         tail = prev;
      }

      prev.next = prev.next.next;
      size--;
   }

   private Node findPrev(int index) {
      Node pred = head;
      for (int i = 0; i < index; ++i) {
         pred = pred.next;
      }
      return pred;
   }

   /** Add an element after the given node. */
   private void addAfter(Node pred, int val) {
      Node node = new Node(val);
      node.next = pred.next;
      pred.next = node;
      size++;
   }

   public static void main(String[] args) {
      MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
      linkedList.addAtHead(1);
      linkedList.addAtTail(3);
      linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
      System.out.println(linkedList.get(1));            // returns 2
      linkedList.deleteAtIndex(1);  // now the linked list is 1->3
      System.out.println(linkedList.get(1));            // returns 3
   }
}
