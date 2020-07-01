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

      final Map<Character, Integer> map = new HashMap<>();
      final int len = s.length();
      int left = 0, right = 0;
      int maxLen = 0;

      while (right < len) {
         final char ch = s.charAt(right);
         if (map.containsKey(ch)) {
            if (map.get(ch) >= left) {
               left = map.get(ch) + 1;
            }
         }

         maxLen = Math.max(maxLen, right - left + 1);
         map.put(ch, right++);
      }

      return maxLen;
   }

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
   }

}
