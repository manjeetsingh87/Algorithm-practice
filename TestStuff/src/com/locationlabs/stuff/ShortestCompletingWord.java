package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class ShortestCompletingWord {
   private static String shortestCompletingWord(String licensePlate, String[] words) {
      if (words == null || words.length == 0) {
         return null;
      }

      int[] target = letterCount(licensePlate.toLowerCase().toCharArray());

      String answer = "";

      for (String word : words) {
         if ((answer.length() == 0 || word.length() < answer.length()) &&
               isShortestMatch(letterCount(word.toLowerCase().toCharArray()), target)) {
            answer = word;
         }
      }
      return answer;
   }

   private static boolean isShortestMatch(int[] currentWordCount, int[] target) {
      for (int i = 0; i < 26; i++) {
         if (currentWordCount[i] < target[i]) {
            return false;
         }
      }
      return true;
   }

   private static int[] letterCount(char[] letters) {
      int[] letterCount = new int[26];
      Arrays.fill(letterCount, 0);

      for (char ch : letters) {
         if (Character.isAlphabetic(ch)) {
            letterCount[ch-'a'] += 1;
         }
      }

      return letterCount;
   }

   public static void main(String[] args) {
      System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
   }
}
