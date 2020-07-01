package com.locationlabs.stuff.amazon;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class FirstUniqueNumber {
   private Set<Integer> uniquesSet;
   private Map<Integer, Boolean> uniquesMap;

   public FirstUniqueNumber(int[] nums) {
      this.uniquesSet = new LinkedHashSet<>();
      this.uniquesMap = new HashMap<>();

      for (int num : nums) {
         this.add(num);
      }
   }

   public int showFirstUnique() {
      if (!this.uniquesSet.isEmpty()) {
         return this.uniquesSet.iterator().next();
      }

      return -1;
   }

   public void add(int value) {
      if (!this.uniquesMap.containsKey(value)) { // new value, add to set and mark as first occurrence
         this.uniquesMap.put(value, true);
         this.uniquesSet.add(value);
      } else if (this.uniquesMap.get(value)) { // value seen before, remove from set and mark unique as false for future calls.
         this.uniquesMap.put(value, false);
         this.uniquesSet.remove(value);
      }
   }
}
