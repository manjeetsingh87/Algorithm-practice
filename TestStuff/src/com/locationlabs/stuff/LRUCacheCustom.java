package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/22/19.
 */
public class LRUCacheCustom {
   private Map<Integer, Node> lruCache;
   private int capacity;
   private Node head, tail;

   public LRUCacheCustom(int capacity) {
      this.lruCache = new HashMap<>();
      this.capacity = capacity;
      this.head = new Node(-1, -1);
      this.tail = new Node(-1, -1);
      join(head, tail);
   }

   public void put(int key, int value) {
      if (lruCache.containsKey(key)) {
         Node node = lruCache.get(key);
         node.val = value;
         removeNode(node);
         moveToHead(node);
         return;
      }

      if (lruCache.size() == capacity) {
         lruCache.remove(tail.prev.key);
         removeNode(tail.prev);
      }

      Node node = new Node(key, value);
      moveToHead(node);
      lruCache.put(key, node);
   }

   public int get(int key) {
      if (!lruCache.containsKey(key)) {
         return -1;
      }

      Node node = lruCache.get(key);
      removeNode(node);
      moveToHead(node);
      return node.val;
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

   private class Node {
      Node prev, next;
      int key;
      int val;

      private Node(int key, int val) {
         this.key = key;
         this.val = val;
      }
   }

   public static void main(String[] args) {
      LRUCacheCustom cache = new LRUCacheCustom(2);
      cache.put(1, 1);
      cache.put(2, 2);
      System.out.println(cache.get(1));
      cache.put(3, 3);
      System.out.println(cache.get(2));
      cache.put(4, 4);
      System.out.println(cache.get(1));
      System.out.println(cache.get(3));
      System.out.println(cache.get(4));
   }
}
