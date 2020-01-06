package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/5/19.
 */
public class MinStack {
   private Node head;

   public void push(int x) {
      if (head == null) {
         head = new Node(x, x, null);
         return;
      }

      head = new Node(x, Math.min(x, head.min), head);
   }

   public void pop() {
      if (head == null) {
         return;
      }
      head = head.next;
   }

   public int top() {
      if (head == null) {
         return Integer.MIN_VALUE;
      }

      return head.val;
   }

   public int getMin() {
      if (head == null) {
         return Integer.MIN_VALUE;
      }
      return head.min;
   }

   private class Node {
      int val;
      int min;
      Node next;

      private Node(int val, int min, Node next) {
         this.val = val;
         this.min = min;
         this.next = next;
      }
   }

   public static void main(String[] args) {
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.top());
      System.out.println(minStack.getMin());
   }
}
