package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/13/19.
 */
public class PalindromeNumber {
   private static boolean isPalindrome(int x) {
      if (x < 0 || (x != 0 && x%10 == 0)) {
         return false;
      }

      int reversed = 0;
      while (x > reversed) {
         reversed = reversed * 10 + x % 10;
         x /= 10;
      }

      return (x == reversed) || (x == reversed/10);
   }

   public static void main(String[] args) {
      System.out.println(isPalindrome(121));
      System.out.println(isPalindrome(-121));
      System.out.println(isPalindrome(010));
   }
}
