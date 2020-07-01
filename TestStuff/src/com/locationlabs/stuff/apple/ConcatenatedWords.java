package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/26/20.
 */
public class ConcatenatedWords {
   private static List<String> findAllConcatenatedWordsInADict(String[] words) {
      final List<String> result = new ArrayList<>();
      if (words == null || words.length <= 1) {
         return result;
      }

      final Set<String> preConcatenatedWords = new HashSet<>();

      Arrays.sort(words, (a, b) -> a.length() - b.length());

      for (String word : words) {
         if (canForm(word, preConcatenatedWords)) {
            result.add(word);
         }
         preConcatenatedWords.add(word);
      }

      return result;
   }

   private static boolean canForm(String word, Set<String> preConcatenatedWords) {
      if (preConcatenatedWords.isEmpty()) {
         return false;
      }

      boolean[] dp = new boolean[word.length() + 1];
      dp[0] = true;

      for (int i = 1; i <= word.length(); i++) {
         for (int j = 0; j < i; j++) {
            if (dp[j] && preConcatenatedWords.contains(word.substring(j, i))) {
               dp[i] = true;
               break;
            }
         }
      }

      return dp[word.length()];
   }

   public static void main(String[] args) {
      System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
   }
}
