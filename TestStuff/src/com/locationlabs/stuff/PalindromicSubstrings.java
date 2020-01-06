package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/9/19.
 */
public class PalindromicSubstrings {
   private static int countSubstrings(String s) {
      if (s == null || s.length() == 0) {
         return 0;
      }

      int count = 0;
      for (int i = 0 ; i < s.length(); i++) {
         count += expandAroundCenter(s, i, i);
         count += expandAroundCenter(s, i, i + 1);
      }

      return count;
   }

   private static int expandAroundCenter(final String s, int left, int right) {
      int count = 0;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
         left--;
         right++;
         count++;
      }

      return count;
   }

   public static void main(String[] args) {
      System.out.println(countSubstrings("abc"));
      System.out.println(countSubstrings("aaa"));
   }
}
