package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by manjeet.singh on 5/13/19.
 */
public class RandomizedSet {

   private Map<Integer, Integer> keyMap;
   private List<Integer> values;
   private Random rand;

   /** Initialize your data structure here. */
   public RandomizedSet() {
      keyMap = new HashMap<>();
      values = new ArrayList<>();
      rand = new Random();
   }

   /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
   public boolean insert(int val) {
      if (keyMap.containsKey(val)) {
         return false;
      }

      keyMap.put(val, values.size());
      values.add(val);
      return true;
   }

   /** Removes a value from the set. Returns true if the set contained the specified element. */
   public boolean remove(int val) {
      if (!keyMap.containsKey(val)) {
         return false;
      }

      int valPos = keyMap.remove(val);
      int last = values.remove(values.size()-1);
      if (last != val) {
         values.set(valPos, last);
         keyMap.put(last, valPos);
      }
      return true;
   }

   /** Get a random element from the set. */
   public int getRandom() {
      return values.get(rand.nextInt(values.size()));
   }

   public static void main(String[] args) {
      RandomizedSet set = new RandomizedSet();
      System.out.println(set.insert(1));
      System.out.println(set.insert(2));
      System.out.println(set.insert(3));
      System.out.println(set.remove(2));
      System.out.println(set.getRandom());
      System.out.println(set.insert(2));
      System.out.println(set.getRandom());
   }
}
