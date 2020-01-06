package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 5/1/19.
 */
public class SortByCharFrequency {
   private static String frequencySort(String s) {
      if (s == null || s.length() < 3) {
         return s;
      }

      Map<Character, Integer> map = new HashMap<>();
      for (char ch : s.toCharArray()) {
         map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      List<Character>[] bucket = new List[s.length()+1];

      for (char ch : map.keySet()) {
         int frequency = map.get(ch);
         if (bucket[frequency]== null) {
            bucket[frequency] = new ArrayList<>();
         }
         bucket[frequency].add(ch);
      }

      StringBuilder res = new StringBuilder();
      for(int i = bucket.length-1; i >= 0; i--) {
         if (bucket[i] != null) {
            for (char ch : bucket[i]) {
               for (int j = 0; j < map.get(ch); j++) {
                  res.append(ch);
               }
            }
         }
       }

      return res.toString();
   }
   public static void main(String[] args) {
      System.out.println(frequencySort("panda"));
   }
}
