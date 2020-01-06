package com.locationlabs.stuff.dropbox;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class LRU {
   private Map<Integer, Node> cache;
   private Node head;
   private Node tail;
   private int capacity;

   public LRU (int capacity) {
      this.cache = new HashMap<>();
      this.capacity = capacity;
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      join(head, tail);
   }

   public int get(int key) {
      if (!cache.containsKey(key)) {
         return -1;
      }

      Node current = cache.get(key);
      removeNode(current);
      moveToHead(current);
      return current.value;
   }

   public void put(int key, int value) {
      if (cache.containsKey(key)) {
         Node node = cache.get(key);
         node.value = value;
         removeNode(node);
         moveToHead(node);
         return;
      }

      if (cache.size() == capacity) {
         cache.remove(tail.prev.key);
         removeNode(tail.prev);
      }

      Node node = new Node(key, value);
      moveToHead(node);
      cache.put(key, node);
   }

   private void removeNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
   }

   private void moveToHead(Node node) {
      Node next = head.next;
      join(head, node);
      join(node, next);
   }

   private void join(Node n1, Node n2) {
      n1.next = n2;
      n2.prev = n1;
   }

   public static void main(String[] args) {
      LRU lru = new LRU(2);
      lru.put(1, 1);
      lru.put(2, 2);
      System.out.println(lru.get(1));
      lru.put(3, 3);
      System.out.println(lru.get(2));
      lru.put(4, 4);
      System.out.println(lru.get(1));
      System.out.println(lru.get(3));
      System.out.println(lru.get(4));
   }

   private class Node {
      int key;
      int value;
      Node prev;
      Node next;

      private Node(int key, int value) {
         this.key = key;
         this.value = value;
      }
   }
}
