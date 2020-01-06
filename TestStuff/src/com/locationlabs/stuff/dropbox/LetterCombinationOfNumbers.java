package com.locationlabs.stuff.dropbox;

import static com.locationlabs.stuff.LetterCombinationOfPhoneNumber.numberLetterMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/21/19.
 */
public class LetterCombinationOfNumbers {
   private static List<String> letterCombinations(String digits) {
      final List<String> result = new ArrayList<>();
      if (digits == null || digits.isEmpty()) {
         return result;
      }
      backtrack(digits, "", result);
      return result;
   }

   private static void backtrack(String nextDigits, String currentCombination, List<String> result) {
      if (nextDigits.length() == 0) {
         result.add(currentCombination);
         return;
      }

      String digit = nextDigits.substring(0, 1);

      if (!numberLetterMap.containsKey(digit)) {
         return;
      }
      String letters = numberLetterMap.get(digit);

      for (char letter : letters.toCharArray()) {
         backtrack(nextDigits.substring(1), currentCombination + letter, result);
      }
   }

   public static void main(String[] args) {
      System.out.println(letterCombinations("23"));
   }
}
