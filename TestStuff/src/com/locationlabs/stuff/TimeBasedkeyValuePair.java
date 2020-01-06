package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 4/8/19.
 */
public class TimeBasedkeyValuePair {

   private Map<String,TreeMap<Integer,String>> map;

   /** Initialize your data structure here. */
   public TimeBasedkeyValuePair() {
      map = new HashMap<>();
   }

   public void set(String key, String value, int timestamp) {
      if(!map.containsKey(key)) {
         map.put(key,new TreeMap<>());
      }
      map.get(key).put(timestamp, value);
   }

   public String get(String key, int timestamp) {
      TreeMap<Integer,String> treeMap = map.getOrDefault(key, null);

      if (treeMap == null) {
         return "";
      }

      Integer floor = treeMap.floorKey(timestamp);
      if (floor == null) {
         return "";
      }
      return treeMap.get(floor);
   }
}
