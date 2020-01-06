package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/14/19.
 */
public class MyHashMap {
   private Node[] map;

   /** Initialize your data structure here. */
   public MyHashMap() {
      this.map = new Node[10000];
   }

   /** value will always be non-negative. */
   public void put(int key, int value) {
      int index = getKeyHash(key);
      Node prev = findElement(index, key);
      if (prev.next == null) {
         prev.next = new Node(key, value);
      } else {
         prev.next.val = value;
      }
   }

   /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
   public int get(int key) {
      int index = getKeyHash(key);
      Node node = findElement(index, key);
      return node.next == null ? -1 : node.next.val;
   }

   /** Removes the mapping of the specified value key if this map contains a mapping for the key */
   public void remove(int key) {
      int index = getKeyHash(key);
      Node prev = findElement(index, key);
      if (prev.next != null) {
         prev.next = prev.next.next;
      }
   }

   private Node findElement(int index, int key) {
      if (map[index] == null) {
         map[index] = new Node(-1, -1);
         return map[index];
      }

      Node prev = map[index];
      while (prev.next != null && prev.next.key != key) {
         prev = prev.next;
      }
      return prev;
   }

   private int getKeyHash(int key) {
      return Integer.hashCode(key) % map.length;
   }

   private class Node {
      int key;
      int val;
      Node next;

      private Node(int key, int val) {
         this.key = key;
         this.val = val;
      }
   }

   public static void main(String[] args) {
      MyHashMap hashMap = new MyHashMap();
      hashMap.put(1, 1);
      hashMap.put(2, 2);
      System.out.println(hashMap.get(1));
      System.out.println(hashMap.get(2));
      System.out.println(hashMap.get(3));
      hashMap.put(2, 1);
      System.out.println(hashMap.get(2));
      hashMap.remove(2);
      System.out.println(hashMap.get(2));
   }
}
