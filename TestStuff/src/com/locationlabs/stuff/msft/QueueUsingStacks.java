package com.locationlabs.stuff.msft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class QueueUsingStacks {
   /** Initialize your data structure here. */
   private Deque<Integer> input;
   private Deque<Integer> output;

   public QueueUsingStacks() {
      input = new ArrayDeque<>();
      output = new ArrayDeque<>();
   }

   /** Push element x to the back of queue. */
   public void push(int x) {
      input.push(x);
   }

   /** Removes the element from in front of queue and returns that element. */
   public int pop() {
      if (output.isEmpty()) {
         reorder();
      }

      return output.pop();
   }

   private void reorder() {
      while (!input.isEmpty()) {
         output.push(input.pop());
      }
   }

   /** Get the front element. */
   public int peek() {
      if (!output.isEmpty()) {
         return output.peek();
      }

      reorder();

      return output.peek();
   }

   /** Returns whether the queue is empty. */
   public boolean empty() {
      return input.isEmpty() && output.isEmpty();
   }

   public static void main(String[] args) {
      final QueueUsingStacks queue = new QueueUsingStacks();
      queue.push(1);
      queue.push(2);
      System.out.println(queue.peek());
      System.out.println(queue.pop());
      System.out.println(queue.empty());
   }
}
