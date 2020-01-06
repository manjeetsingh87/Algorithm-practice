package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class SubstringWithConcatOfAllWords {
   private static List<Integer> findSubstring(String s, String[] words) {
      final List<Integer> indexes = new ArrayList<>();
      if (s == null || s.isEmpty() || words == null || words.length == 0) {
         return indexes;
      }

      int wordLen = words[0].length();
      int arrayLen = words.length;
      int window = wordLen * arrayLen;

      if (s.length() < window) {
         return indexes;
      }

      final Map<String, Integer> countsMap = new HashMap<>();
      for (String word : words) {
         countsMap.put(word, countsMap.getOrDefault(word, 0) + 1);
      }

      for (int i = 0; i < s.length() - window + 1; i++) {
         final Map<String, Integer> seen = new HashMap<>();
         int start = i, currentWindow = i + window + 1;
         while (start + wordLen < currentWindow) {
            final String currentWord = s.substring(start, start + wordLen);
            if (countsMap.containsKey(currentWord)) {
               seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
               if (seen.get(currentWord) > countsMap.get(currentWord)) {
                  break;
               }
            } else {
               break;
            }
            start += wordLen;
         }
         if (countsMap.equals(seen)) {
            indexes.add(i);
         }
      }

      return indexes;
   }

   public static void main(String[] args) {
      System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
      System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
   }
}
