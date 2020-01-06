package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/20/19.
 */
public class WordPattern {
   private static boolean wordPattern(String pattern, String str) {
      if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) {
         return false;
      }

      String[] strArr = str.split("\\s");
      if (pattern.length() != strArr.length) {
         return false;
      }

      final Map<Character, String> map = new HashMap<>();
      final Set<String> set = new HashSet<>();
      for (int i = 0; i < strArr.length; i++) {
         final char ch = pattern.charAt(i);
         final String word = strArr[i];
         if (!map.containsKey(ch)) {
            if (!set.add(word)) {
               return false;
            }
            map.put(ch, word);
         } else if (!map.get(ch).equals(word)) {
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(wordPattern("abba", "dog cat cat dog"));
      System.out.println(wordPattern("abba", "dog cat cat fish"));
      System.out.println(wordPattern("aaaa", "dog cat cat dog"));
      System.out.println(wordPattern("abba", "dog dog dog dog"));
   }
}
