package com.locationlabs.stuff.facebook;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class LongestSubstringWithKDistinctChars {
   private static int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (s == null) {
         return 0;
      }

      int len = s.length();
      if (len * k == 0) {
         return 0;
      }

      int max = 0;
      int left = 0, right = 0;
      final LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

      while (right < len) {
         char ch = s.charAt(right);

         // if map already contains this character in a previous window,
         // remove that occurance and add the char again at rightmost pos
         if (map.containsKey(ch)) {
            map.remove(ch);
         }

         map.put(ch, right++);

         if (map.size() == k + 1) {
            Map.Entry<Character, Integer> leftMostEntry = map.entrySet().iterator().next();
            map.remove(leftMostEntry.getKey());
            left = leftMostEntry.getValue() + 1;
         }

         max = Math.max(max, right - left);
      }

      return max;
   }

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
      System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
   }
}
