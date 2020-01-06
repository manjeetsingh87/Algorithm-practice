package com.locationlabs.stuff.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class GoatLatin {
   private static String toGoatLatin(String S) {
      if (S == null || S.isEmpty()) {
         return S;
      }

      final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
      final String MA = "ma";
      final String A = "a";
      final StringBuilder result = new StringBuilder();
      int index = 1;
      for (String word : S.split("\\s")) {
         char firstChar = word.charAt(0);
         if (vowels.contains(firstChar)) {
            result.append(word);
         } else {
            result.append(word.substring(1));
            result.append(firstChar);
         }
         result.append(MA);
         for (int i = 0; i < index; i++) {
            result.append(A);
         }
         index++;
         result.append(" ");
      }

      return result.toString().trim();
   }

   public static void main(String[] args) {
      System.out.println(toGoatLatin("I speak Goat Latin"));
      System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
   }
}
