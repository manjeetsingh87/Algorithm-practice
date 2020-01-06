package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * Created by manjeet.singh on 3/26/19.
 */
public class LongestPalindrome {
   private static String longestPalindrome(String s) {
      if (s == null || s.length() == 0)
         return "";

      String result = "";
      int count = 0;

      for (int i=0; i < s.length(); i++) {
         Pair<String, Integer> pair = expandAroundCenter(s, i, i);
         String s1 = pair.getKey();
         count += pair.getValue();

         if (s1.length() > result.length()) {
            result = s1;
         }

         Pair<String, Integer> pair2 = expandAroundCenter(s, i, i+1);
         String s2 = pair2.getKey();
         count += pair2.getValue();
         if (s2.length() > result.length()) {
            result = s2;
         }
      }
      System.out.println(count);
      return result;
   }

   private static Pair<String, Integer> expandAroundCenter(String s, int left, int right) {
      int count = 0;
      while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
         left--;
         right++;
         count++;
      }
      return new Pair<>(s.substring(left+1, right), count);
   }

   public static void main(String[] args) {
      System.out.println(longestPalindrome("bbbab"));
      System.out.println(longestPalindrome("cbbd"));
      System.out.println(longestPalindrome("aaa"));
   }
}
