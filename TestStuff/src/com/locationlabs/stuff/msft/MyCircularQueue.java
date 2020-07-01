package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/12/20.
 */
public class MyCircularQueue {
   private class Node {
      private int val;
      private Node next;

      // default constructor
      protected Node() {

      }

      // constructor
      protected Node (int val) {
         this.val = val;
         this.next = new Node();
      }
   }

   private int capacity;
   private int count;
   private Node head, tail;

   /** Initialize your data structure here. Set the size of the queue to be k. */
   public MyCircularQueue(int k) {
      this.capacity = k;
   }

   /** Insert an element into the circular queue. Return true if the operation is successful. */
   public boolean enQueue(int value) {
      if (this.count == this.capacity) {
         return false;
      }

      final Node curr = new Node(value);
      if (this.count == 0) {
         this.head = this.tail = curr;
      } else {
         this.tail.next =curr;
         this.tail = curr;
      }

      this.count++;
      return true;
   }

   /** Delete an element from the circular queue. Return true if the operation is successful. */
   public boolean deQueue() {
      if (this.count == 0) {
         return false;
      }

      this.head = this.head.next;

      this.count--;
      return true;
   }

   /** Get the front item from the queue. */
   public int Front() {
      if (this.count == 0) {
         return -1;
      }

      return this.head.val;
   }

   /** Get the last item from the queue. */
   public int Rear() {
      if (this.count == 0) {
         return -1;
      }

      return this.tail.val;
   }

   /** Checks whether the circular queue is empty or not. */
   public boolean isEmpty() {
      return this.count == 0;
   }

   /** Checks whether the circular queue is full or not. */
   public boolean isFull() {
      return this.count == this.capacity;
   }

   public static void main(String[] args) {
      MyCircularQueue queue = new MyCircularQueue(3);
      System.out.println(queue.enQueue(1));
      System.out.println(queue.enQueue(2));
      System.out.println(queue.enQueue(3));
      System.out.println(queue.enQueue(4));
      System.out.println(queue.Rear());
      System.out.println(queue.isFull());
      System.out.println(queue.deQueue());
      System.out.println(queue.enQueue(4));
      System.out.println(queue.Rear());
      System.out.println(queue.deQueue());
      System.out.println(queue.Front());
   }
}
