package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class ValidPalindromeII {
   private static boolean validPalindrome(String s) {
      if (s == null || s.isEmpty()) {
         return true;
      }

      int left = 0, right = s.length() - 1;
      while (left < right) {
         if (s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
         } else {
            return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
         }
      }
      return true;
   }

   private static boolean isPalindrome(String str, int left, int right) {
      while (left <= right) {
         if (str.charAt(left) != str.charAt(right)) {
            return false;
         }
         left++;
         right--;
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(validPalindrome("aba"));
      System.out.println(validPalindrome("abca"));
   }
}
