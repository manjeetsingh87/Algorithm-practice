package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/27/19.
 */
public class GroupAnagrams {
   private static List<List<String>> groupAnagrams(String[] strs) {
      if (strs == null || strs.length == 0) {
         return null;
      }

      final Map<String, List<String>> anagramsMap = new HashMap<>();

      for (String str : strs) {
         int[] wrdArr = new int[26];
         for (char ch : str.toCharArray()) {
            wrdArr[ch - 'a']++;
         }

         String anagramHash = Arrays.toString(wrdArr);
         List<String> anagramSet = anagramsMap.getOrDefault(anagramHash, new ArrayList<>());
         if (!anagramSet.isEmpty()) {
            anagramsMap.get(anagramHash).add(str);
         } else {
            anagramSet.add(str);
            anagramsMap.put(anagramHash, anagramSet);
         }
      }

      final List<List<String>> anagrams = new ArrayList<>();
      for (List<String> anagramList : anagramsMap.values()) {
         anagrams.add(anagramList);
      }

      return anagrams;
   }

   public static void main(String[] args) {
      System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
      System.out.println(groupAnagrams(new String[]{"", ""}));
   }
}
