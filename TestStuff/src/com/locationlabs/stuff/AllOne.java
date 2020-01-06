package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 7/15/19.
 */
public class AllOne {
   private class Node {
      int count;
      Set<String> keys;
      Node prev;
      Node next;

      // default constructor
      private Node() {

      }

      // overloaded constructor
      private Node(String key, int count) {
         this.count = count;
         this.keys = new HashSet<>();
         this.keys.add(key);
      }
   }

   private class DoublyLinkedList {
      Node head, tail;
      int len;

      private DoublyLinkedList() {
         head = new Node();
         tail = new Node();

         head.count = Integer.MIN_VALUE;
         tail.count = Integer.MAX_VALUE;

         join(head, tail);
      }

      private void addNode(Node node, Node next) {
         join(next.prev, node);
         join(node, next);
         len++;
      }

      private void removeNode(Node node) {
         node.prev.next = node.next;
         node.next.prev = node.prev;
         len--;
      }

      private void join(Node n1, Node n2) {
         n1.next = n2;
         n2.prev = n1;
      }
   }

   private Map<String, Node> map;
   private DoublyLinkedList dll;

   /** Initialize your data structure here. */
   public AllOne() {
      map = new HashMap<>();
      dll = new DoublyLinkedList();
   }

   /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
   public void inc(String key) {
      // if this is a new key
      if (!map.containsKey(key)) {
         Node first = dll.head.next;
         // check if we have the Node whose count is 1;
         if (first.count == 1) {
            first.keys.add(key);
            map.put(key, first);
         } else {
            Node newNode = new Node(key, 1);
            dll.addNode(newNode, first);
            map.put(key, newNode);
         }
         return;
      }

      // if key already exists
      Node node = map.get(key);
      node.keys.remove(key);

      if (node.keys.isEmpty()) {
         dll.removeNode(node);
      }

      Node next = node.next;
      int count = node.count;

      if (count + 1 != next.count) {
         Node newNode = new Node(key, count + 1);
         dll.addNode(newNode, next);
         map.put(key, newNode);
      } else {
         next.keys.add(key);
         map.put(key, next);
      }
   }

   /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
   public void dec(String key) {
      if (!map.containsKey(key)) {
         return;
      }

      Node node = map.get(key);
      Node prev = node.prev;
      int count = node.count;
      node.keys.remove(key);

      if (node.keys.isEmpty()) {
         dll.removeNode(node);
      }

      if (prev.count == count - 1) {
         prev.keys.add(key);
         map.put(key, prev);
      } else if (count > 1) {
         Node newNode = new Node(key, count - 1);
         dll.addNode(newNode, prev.next);
         map.put(key, newNode);
      } else {
         map.remove(key);
      }
   }

   /** Returns one of the keys with maximal value. */
   public String getMaxKey() {
      if (dll.len == 0) {
         return "";
      }

      Node node = dll.tail.prev;
      return node.keys.iterator().next();
   }

   /** Returns one of the keys with Minimal value. */
   public String getMinKey() {
      if (dll.len == 0) {
         return "";
      }

      Node node = dll.head.next;
      return node.keys.iterator().next();
   }

   public static void main(String[] args) {
      AllOne allOne = new AllOne();
      allOne.inc("a");
      allOne.inc("b");
      allOne.inc("b");
      allOne.inc("b");
      allOne.inc("b");
      allOne.dec("b");
      allOne.dec("b");
      System.out.println(allOne.getMaxKey());
      System.out.println(allOne.getMinKey());
   }
}
