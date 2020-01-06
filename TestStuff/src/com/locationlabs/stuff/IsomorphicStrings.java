package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class IsomorphicStrings {
   private static boolean isIsomorphic(String s, String t) {
      if ((s == null && t == null) || (s.isEmpty() && t.isEmpty())) {
         return true;
      }

      if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
         return false;
      }

      if (s.length() != t.length()) {
         return false;
      }

      final Map<Character, Character> map = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
         char sChar = s.charAt(i);
         char tChar = t.charAt(i);

         if (map.containsKey(sChar)) {
            if (tChar != map.get(sChar)) {
               return false;
            }
         } else {
            if (map.containsValue(tChar)) {
               return false;
            } else {
               map.put(sChar, tChar);
            }
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(isIsomorphic("egg", "add"));
      System.out.println(isIsomorphic("foo", "bar"));
      System.out.println(isIsomorphic("paper", "title"));
      System.out.println(isIsomorphic("ab", "aa"));
   }
}
