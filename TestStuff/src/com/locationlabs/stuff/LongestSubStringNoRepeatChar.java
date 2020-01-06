package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/24/19.
 */
public class LongestSubStringNoRepeatChar {

   private static int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      int lastOccurance = 0, max = 0;
      final Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
         char ch = s.charAt(i);
         if (map.containsKey(ch)) {
            lastOccurance = Math.max(map.get(ch), lastOccurance);
         }
         max = Math.max(max, i - lastOccurance + 1);
         map.put(ch, i + 1);
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
   }

}
