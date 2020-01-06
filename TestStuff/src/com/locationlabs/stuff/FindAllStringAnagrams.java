package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 6/5/19.
 */
public class FindAllStringAnagrams {
   private static List<Integer> findAnagrams(String s, String p) {
      final List<Integer> anagrams = new ArrayList<>();
      if(s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
         return anagrams;
      }

      final Map<Character, Integer> map = new HashMap<>();
      for (char ch : p.toCharArray()) {
         map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      int begin = 0, end = 0;
      int counter = 0;

      while (end < s.length()) {
         char ch = s.charAt(end++);
         if (!map.containsKey(ch)) {
            continue;
         }

         map.put(ch, map.get(ch)-1);
         if(map.get(ch) >= 0) {
            counter++;
         }

         while(counter == p.length()){
            char temp = s.charAt(begin);
            if(map.containsKey(temp)){
               map.put(temp, map.get(temp) + 1);
               if(map.get(temp) > 0){
                  counter--;
               }
            }
            if(end-begin == p.length()){
               anagrams.add(begin);
            }
            begin++;
         }
      }

      return anagrams;
   }

   public static void main(String[] args) {
      System.out.println(findAnagrams("cbaebabacd", "abc"));
      System.out.println(findAnagrams("abab", "ab"));
      System.out.println(findAnagrams("baa", "aa"));
   }
}
