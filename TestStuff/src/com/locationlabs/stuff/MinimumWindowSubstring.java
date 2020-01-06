package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/15/19.
 */
public class MinimumWindowSubstring {
   private static String minWindow(String s, String t) {
      if (s == null || t == null || s.length() < t.length()) {
         return "";
      }

      final Map<Character, Integer> map = new HashMap<>();
      for (char ch : t.toCharArray()) {
         int count = map.getOrDefault(ch, 0);
         map.put(ch, count + 1);
      }

      int right = 0, left = 0, min = s.length() + 1;
      String result = "";
      int count = 0;
      while (right < s.length()) {
         char ch = s.charAt(right++);
         if (!map.containsKey(ch)) {
            continue;
         }

         map.put(ch, map.get(ch) - 1);
         if (map.get(ch) >= 0) {
            count++;
         }

         while (count == t.length()) {
            while (left < right && !map.containsKey(s.charAt(left))) {
               left++;
            }

            if (right - left < min) {
               min = right - left;
               result = s.substring(left, right);
            }

            char ch1 = s.charAt(left);
            map.put(ch1, map.get(ch1) + 1);
            if (map.get(ch1) > 0) {
               count--;
            }
            left++;
         }
      }

      System.out.println(result.isEmpty() ? "null" : result);
      return result;
   }

   public static void main(String[] args) {
      minWindow("ADOBECODEBANC", "ABC");
      minWindow("aghaghbc", "abc");
      minWindow("aghaghb", "abc");
   }
}
