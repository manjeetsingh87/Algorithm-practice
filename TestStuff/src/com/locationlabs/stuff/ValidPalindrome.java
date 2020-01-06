package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/5/19.
 */
public class ValidPalindrome {
   private static boolean isPalindrome(String s) {
      if (s == null || s.isEmpty()) {
         return true;
      }

      s = s.toLowerCase();
      int start = 0, end = s.length() - 1;
      while (start < end) {
         char sChar = s.charAt(start);
         char eChar = s.charAt(end);
         if (!Character.isAlphabetic(sChar) && !Character.isDigit(sChar)) {
            start++;
         } else if (!Character.isAlphabetic(eChar) && !Character.isDigit(eChar)) {
            end--;
         } else if (sChar != eChar) {
            return false;
         } else {
            start++;
            end--;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
      System.out.println(isPalindrome("race a car"));
   }
}
