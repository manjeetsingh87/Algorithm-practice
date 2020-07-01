package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class RansomNote {
   private static boolean canConstruct(String ransomNote, String magazine) {
      final Map<Character, Integer> ransomCharCounts = new HashMap<>();
      for (char ch : ransomNote.toCharArray()) {
         ransomCharCounts.put(ch, ransomCharCounts.getOrDefault(ch, 0) + 1);
      }

      for (char ch : magazine.toCharArray()) {
         if (!ransomCharCounts.containsKey(ch)) {
            continue;
         }
         int prevCharCount = ransomCharCounts.put(ch, ransomCharCounts.get(ch) - 1);

         if (prevCharCount - 1 == 0) {
            ransomCharCounts.remove(ch);
         }

         if (ransomCharCounts.isEmpty()) {
            return true;
         }
      }

      return ransomCharCounts.isEmpty();
   }

   public static void main(String[] args) {
      System.out.println(canConstruct("a", "b"));
      System.out.println(canConstruct("aa", "ab"));
      System.out.println(canConstruct("aa", "aab"));
      System.out.println(canConstruct("", "a"));
   }
}
