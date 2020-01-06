package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 7/5/19.
 */
public class MaxStack {
   private DoublyLinkedList dll;
   private TreeMap<Integer, List<Node>> maxStack;

   public MaxStack() {
      dll = new DoublyLinkedList();
      maxStack = new TreeMap<>();
   }

   public void push(int x) {
      Node node = dll.add(x);
      maxStack.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
   }

   public int pop() {
      int val = dll.pop();
      List<Node> keyNodes = maxStack.get(val);
      keyNodes.remove(keyNodes.size() - 1);
      if (keyNodes.isEmpty()) {
         maxStack.remove(val);
      }
      return val;
   }

   public int top() {
      return dll.peek();
   }

   public int peekMax() {
      return maxStack.lastKey();
   }

   public int popMax() {
      int max = peekMax();
      List<Node> curr = maxStack.get(max);
      Node node = curr.remove(curr.size() - 1);
      dll.unlink(node);
      if (curr.isEmpty()) {
         maxStack.remove(max);
      }
      return max;
   }

   private class DoublyLinkedList {
      Node head, tail;

      private DoublyLinkedList() {
         head = new Node(0);
         tail = new Node(0);
         head.next = tail;
         tail.prev = head;
      }

      private Node add(int x) {
         Node node = new Node(x);
         node.next = tail;
         node.prev = tail.prev;
         tail.prev = tail.prev.next = node;
         return node;
      }

      private int peek() {
         return tail.prev.val;
      }

      private int pop() {
         return unlink(tail.prev).val;
      }

      private Node unlink(Node node) {
         node.prev.next = node.next;
         node.next.prev = node.prev;
         return node;
      }
   }

   private class Node {
      int val;
      Node next, prev;

      private Node(int val) {
         this.val = val;
      }
   }

   public static void main(String[] args) {
      MaxStack stack = new MaxStack();
      stack.push(5);
      stack.push(1);
      stack.push(5);
      System.out.println(stack.top());
      System.out.println(stack.popMax());
      System.out.println(stack.top());
      System.out.println(stack.peekMax());
      System.out.println(stack.pop());
      System.out.println(stack.top());
   }
}
