package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class LetterCasePermutation {
   private static List<String> letterCasePermutation(String S) {
      final List<String> permutations = new ArrayList<>();

      if (S == null || S.isEmpty()) {
         return permutations;
      }

      backtrack(permutations, 0, S.toCharArray());
      return permutations;
   }

   private static void backtrack(List<String> permutations, int idx, char[] chars) {
      if (idx == chars.length) {
         permutations.add(new String(chars));
         return;
      }

      final char ch = chars[idx];
      if (Character.isAlphabetic(ch)) {
         chars[idx] = Character.toUpperCase(ch);
         backtrack(permutations, idx + 1, chars);
         chars[idx] = Character.toLowerCase(ch);
         backtrack(permutations, idx + 1, chars);
      } else {
         backtrack(permutations, idx + 1, chars);
      }
   }

   public static void main(String[] args) {
      System.out.println(letterCasePermutation("a1b2"));
      System.out.println(letterCasePermutation("3z4"));
      System.out.println(letterCasePermutation("12345"));
   }
}
