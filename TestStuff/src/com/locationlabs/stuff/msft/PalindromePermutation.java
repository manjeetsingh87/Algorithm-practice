package com.locationlabs.stuff.msft;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class PalindromePermutation {
   private static boolean canPermutePalindrome(String s) {
      if (s == null || s.isEmpty() || s.length() == 1) {
         return true;
      }

      final Set<Character> set = new HashSet<>();

      for (char ch : s.toCharArray()) {
         if (!set.add(ch)) {
            set.remove(ch);
         }
      }

      return set.size() <= 1;
   }

   public static void main(String[] args) {
      System.out.println(canPermutePalindrome("code"));
      System.out.println(canPermutePalindrome("aab"));
      System.out.println(canPermutePalindrome("carerac"));
   }
}
