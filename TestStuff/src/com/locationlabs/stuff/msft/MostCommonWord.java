package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class MostCommonWord {
   private static String mostCommonWord(String paragraph, String[] banned) {
      if (paragraph == null || paragraph.isEmpty()) {
         return null;
      }

      final Set<String> bannedWords = Arrays.stream(banned).collect(Collectors.toSet());


      final String formattedParagraph = paragraph.replaceAll("[!?',;.]", "");
      final Map<String, Integer> wordCountMap = new HashMap<>();

      String mostFrequentWord = "";
      int maxOccuranceCount = 0;
      for (String word : formattedParagraph.toLowerCase().split("\\s+")) {
         if (bannedWords.contains(word)) {
            continue;
         }

         int wordCount = wordCountMap.getOrDefault(word, 0);
         wordCountMap.put(word, wordCount + 1);

         if (wordCount + 1 > maxOccuranceCount) {
            maxOccuranceCount = wordCount + 1;
            mostFrequentWord = word;
         }
      }

      return mostFrequentWord;
   }

   public static void main(String[] args) {
      System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
   }
}
