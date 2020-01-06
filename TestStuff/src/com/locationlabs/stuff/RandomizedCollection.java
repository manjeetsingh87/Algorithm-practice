package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class RandomizedCollection {
   private Map<Integer, Set<Integer>> keyMap;
   private List<Integer> values;
   private Random rand;

   /** Initialize your data structure here. */
   public RandomizedCollection() {
      keyMap = new HashMap<>();
      values = new ArrayList<>();
      rand = new Random();
   }

   /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
   public boolean insert(int val) {
      final Set<Integer> indexSet = keyMap.getOrDefault(val, new LinkedHashSet<>());
      indexSet.add(values.size());
      keyMap.put(val, indexSet);
      values.add(val);
      return keyMap.get(val).size() == 1;
   }

   /** Removes a value from the collection. Returns true if the collection contained the specified element. */
   public boolean remove(int val) {
      if (!keyMap.containsKey(val) || keyMap.get(val).isEmpty()) {
         return false;
      }

      int valPos = keyMap.get(val).iterator().next();
      keyMap.get(val).remove(valPos);
      int last = values.get(values.size() - 1);
      values.set(valPos, last);
      keyMap.get(last).add(valPos);
      keyMap.get(last).remove(values.size() - 1);
      values.remove(values.size() - 1);

      return true;
   }

   /** Get a random element from the collection. */
   public int getRandom() {
      return values.get(rand.nextInt(values.size()));
   }

   public static void main(String[] args) {
      RandomizedCollection collection = new RandomizedCollection();
      System.out.println(collection.insert(1));
      System.out.println(collection.insert(1));
      System.out.println(collection.insert(2));
      System.out.println(collection.getRandom());
      System.out.println(collection.remove(1));
      System.out.println(collection.getRandom());
   }
}
