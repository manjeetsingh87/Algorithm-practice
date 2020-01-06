package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/19/19.
 */
public class FindAllStrAnagrams {
   private static  List<Integer> findAnagrams(String s, String p) {
      final List<Integer> anagrams = new ArrayList<>();
      if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
         return anagrams;
      }

      final Map<Character, Integer> pCounts = new HashMap<>();
      for (char ch : p.toCharArray()) {
         pCounts.put(ch, pCounts.getOrDefault(ch, 0) + 1);
      }

      // maintain a left pos of the sliding window and a right pos
      int left = 0, right = 0;
      int count = 0;

      while (right < s.length()) {
         char sChar = s.charAt(right++);
         if (!pCounts.containsKey(sChar)) {
            continue;
         }

         pCounts.put(sChar, pCounts.get(sChar) - 1);
         if (pCounts.get(sChar) >= 0) {
            count++;
         }

         while (count == p.length()) {
            char tmp = s.charAt(left);
            if (pCounts.containsKey(tmp)) {
               pCounts.put(tmp, pCounts.get(tmp) + 1);
               if (pCounts.get(tmp) > 0) {
                  count--;
               }
            }

            if (right - left == p.length()) {
               anagrams.add(left);
            }
            left++;
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
