package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by manjeet.singh on 10/2/19.
 */
public class LFUCache {
   private Map<Integer, Integer> keyToVal;
   private Map<Integer, Integer> keyToCount;
   private Map<Integer, LinkedHashSet<Integer>> countToLRUKeys;
   private int capacity;
   private int min;

   public LFUCache(int capacity) {
      this.min = -1;
      this.capacity = capacity;
      this.keyToVal = new HashMap<>();
      this.keyToCount = new HashMap<>();
      this.countToLRUKeys = new HashMap<>();
   }

   public int get(int key) {
      if (!keyToVal.containsKey(key)) {
         return -1;
      }

      int count = keyToCount.get(key);

      // remove key from current count (since we will inc count)
      countToLRUKeys.get(count).remove(key);

      // nothing in the current min bucket, update min to next min bucket
      if (count == min && countToLRUKeys.get(count).isEmpty()) {
         min++;
      }

      putCount(key, count + 1);
      return keyToVal.get(key);
   }

   public void put(int key, int value) {
      if (capacity <= 0) {
         return;
      }

      if (keyToVal.containsKey(key)) {
         keyToVal.put(key, value); // update key's value
         get(key); // update key's count
         return;
      }

      if (keyToVal.size() >= capacity) {
         // evict LRU from this min count bucket
         evict(countToLRUKeys.get(min).iterator().next());
      }

      min = 1;

      // adding new key and count
      putCount(key, min);

      // adding new key and value
      keyToVal.put(key, value);
   }

   private void putCount(int key, int count) {
      keyToCount.put(key, count);
      countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
      countToLRUKeys.get(count).add(key);
   }

   private void evict(int key) {
      countToLRUKeys.get(min).remove(key);
      keyToVal.remove(key);
   }

   public static void main(String[] args) {
      final LFUCache cache = new LFUCache(2);
      cache.put(1, 1);
      cache.put(2, 2);
      System.out.println(cache.get(1));
      cache.put(3, 3);
      System.out.println(cache.get(2));
      System.out.println(cache.get(3));
      cache.put(4, 4);
      System.out.println(cache.get(1));
      System.out.println(cache.get(3));
      System.out.println(cache.get(4));

   }
}
