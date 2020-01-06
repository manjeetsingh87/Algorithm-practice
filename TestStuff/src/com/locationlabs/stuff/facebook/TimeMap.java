package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class TimeMap {
   private final Map<String, TreeMap<Integer, String>> map;

   /** Initialize your data structure here. */
   public TimeMap() {
      map = new HashMap<>();
   }

   public void set(String key, String value, int timestamp) {
      if (!map.containsKey(key)) {
         final TreeMap<Integer, String> timeMap = new TreeMap<>();
         timeMap.put(timestamp, value);
         map.put(key, timeMap);
         return;
      }

      map.get(key).put(timestamp, value);
   }

   public String get(String key, int timestamp) {
      if (!map.containsKey(key)) {
         return "";
      }

      TreeMap<Integer, String> timeMap = map.get(key);
      final Integer timestampKey = timeMap.floorKey(timestamp);
      if (timestampKey == null) {
         return "";
      }
      return timeMap.get(timestampKey);
   }
}
