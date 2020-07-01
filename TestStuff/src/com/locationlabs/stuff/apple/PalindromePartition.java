package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by manjeet.singh on 5/28/20.
 */
public class PalindromePartition {
   private static List<List<String>> partition(String s) {
      final List<List<String>> result = new ArrayList<>();

      if (s == null || s.isEmpty()) {
         return result;
      }

      if (s.length() == 1) {
         result.add(Collections.singletonList(s));
         return result;
      }

      backtrack(s, 0, result, new ArrayList<>());

      return result;
   }

   private static void backtrack(String s, int currIdx, List<List<String>> result, List<String> current) {
      if (currIdx == s.length()) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = currIdx; i < s.length(); i++) {
         if (isPalindrome(s, currIdx, i)) {
            current.add(s.substring(currIdx, i + 1));
            backtrack(s, i + 1, result, current);
            current.remove(current.size() - 1);
         }
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
      System.out.println(partition("a"));
      System.out.println(partition("aab"));
   }
}
