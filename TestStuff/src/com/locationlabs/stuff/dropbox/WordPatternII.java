package com.locationlabs.stuff.dropbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class WordPatternII {
   private static boolean wordPatternMatch(String pattern, String str) {
      if ((str == null && pattern == null) || (pattern.isEmpty() && str.isEmpty())) {
         return true;
      }

      if ((str == null || pattern == null) || (str.isEmpty() || pattern.isEmpty())) {
         return false;
      }

      final Map<Character, String> map = new HashMap<>();
      final Set<String> set = new HashSet<>();
      return helper(str, 0, pattern, 0, map, set);
   }

   private static boolean helper(String str, int strIdx, String pattern, int patternIdx,
                                 Map<Character, String> map, Set<String> set) {
      if (strIdx == str.length() && patternIdx == pattern.length()) {
         return true;
      }

      if (strIdx == str.length() || patternIdx == pattern.length()) {
         return false;
      }

      char patternCh = pattern.charAt(patternIdx);
      for (int idx = strIdx; idx < str.length(); idx++) {
         final String current = str.substring(strIdx, idx + 1);
         if (map.containsKey(patternCh) && map.get(patternCh).equals(current)) {
            if (helper(str, idx + 1, pattern, patternIdx + 1, map, set)) {
               return true;
            }
         } else if (!map.containsKey(patternCh) && !set.contains(current)) {
            map.put(patternCh, current);
            set.add(current);
            if (helper(str, idx + 1, pattern, patternIdx + 1, map, set)) {
               return true;
            }
            map.remove(patternCh);
            set.remove(current);
         }
      }

      return false;
   }

   public static void main(String[] args) {
      System.out.println(wordPatternMatch("abab", "redblueredblue"));
   }
}
