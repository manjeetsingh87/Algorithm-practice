package com.locationlabs.stuff.msft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class StackUsingQueues {
   private Queue<Integer> queue;

   /** Initialize your data structure here. */
   public StackUsingQueues() {
      this.queue = new LinkedList<>();
   }

   /** Push element x onto stack. */
   public void push(int x) {
      queue.add(x);
      for (int i = 1; i < queue.size(); i++) {
         queue.add(queue.remove());
      }
   }

   /** Removes the element on top of the stack and returns that element. */
   public int pop() {
      return queue.remove();
   }

   /** Get the top element. */
   public int top() {
      return queue.peek();
   }

   /** Returns whether the stack is empty. */
   public boolean empty() {
      return queue.isEmpty();
   }

   public static void main(String[] args) {
      final StackUsingQueues stack = new StackUsingQueues();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      System.out.println(stack.top());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.empty());
   }
}
