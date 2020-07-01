package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class PalindromePartitioning {
   private static List<List<String>> partition(String s) {
      if (s == null || s.isEmpty()) {
         return new ArrayList<>();
      }

      final List<List<String>> result = new ArrayList<>();
      backtrack(s, 0, result, new ArrayList<>());
      return result;
   }

   private static void backtrack(String s, int currIdx, List<List<String>> result, List<String> current) {
      if (currIdx == s.length()) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = currIdx; i < s.length(); i++) {
         // check if current substring is palindrome
         if (!isPalindrome(s, currIdx, i)) {
            continue;
         }

         current.add(s.substring(currIdx, i + 1));
         backtrack(s, i + 1, result, current);
         current.remove(current.size() - 1);
      }
   }

   private static boolean isPalindrome(String str, int start, int end) {
      while (start < end) {
         if (str.charAt(start++) != str.charAt(end--)) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(partition("aab"));
   }
}
