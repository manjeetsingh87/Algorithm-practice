package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class TwoSumDataStructure {
   private List<Integer> numbers;
   private Map<Integer, Integer> map;

   /** Initialize your data structure here. */
   public TwoSumDataStructure() {
      numbers = new ArrayList<>();
      map = new HashMap<>();
   }

   /** Add the number to an internal data structure.. */
   public void add(int number) {
      numbers.add(number);
      if (map.containsKey(number)) {
         map.put(number, map.get(number)+1);
      } else {
         map.put(number, 1);
      }
   }

   /** Find if there exists any pair of numbers which sum is equal to the value. */
   public boolean find(int value) {
      for (int num : numbers) {
         int target = value - num;

         if ((num == target && map.get(num) > 1) ||
                 (num != target && map.containsKey(target))) {
            return true;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      TwoSumDataStructure twoSumDS = new TwoSumDataStructure();
      twoSumDS.add(1);
      twoSumDS.add(3);
      twoSumDS.add(5);

      System.out.println(twoSumDS.find(4));
      System.out.println(twoSumDS.find(7));
   }
}
