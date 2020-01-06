package com.locationlabs.stuff.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class PermutationInString {
   private static boolean checkInclusion(String s1, String s2) {
      if (s1 == null && s2 == null) {
         return true;
      }

      if (s1 == null || s2 == null) {
         return false;
      }

      int len = s1.length();
      final Map<Character, Integer> map = new HashMap<>();
      for(char ch : s1.toCharArray()) {
         map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
      int count = 0;
      int begin = 0;
      int end = 0;
      while(end < s2.length()) {
         char ch = s2.charAt(end++);
         if (!map.containsKey(ch)) {
            continue;
         }

         map.put(ch, map.get(ch) - 1);
         if(map.get(ch) >= 0) {
            count++;
         }

         while(count == len) {
            if(end - begin == len) {
               return true;
            }
            char temp = s2.charAt(begin);
            if(map.containsKey(temp)) {
               map.put(temp, map.get(temp) + 1);
               if(map.get(temp) > 0) {
                  count--;
               }
            }
            begin++;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      System.out.println(checkInclusion("ab", "eidbaooo"));
      System.out.println(checkInclusion("ab", "eidboaoo"));
   }
}
