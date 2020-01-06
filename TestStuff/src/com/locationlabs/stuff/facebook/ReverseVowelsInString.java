package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 7/19/19.
 */
public class ReverseVowelsInString {
   private static final String vowels = "AEIOUaeiou";

   private static String reverseVowels(String s) {
      if (s == null || s.isEmpty()) {
         return s;
      }

      char[] sChars = s.toCharArray();
      int left = 0, right = sChars.length - 1;
      while (left < right) {
         while (left < right && !isVowel(sChars[left])) {
            left++;
         }

         while (left < right && !isVowel(sChars[right])) {
            right--;
         }

         swap(left, right, sChars);
         left++;
         right--;
      }

      return new String(sChars);
   }

   private static boolean isVowel(char ch) {
      if (vowels.indexOf(ch) < 0) {
         return false;
      }

      return true;
   }

   private static void swap(int i, int j, char[] chars) {
      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
   }

   public static void main(String[] args) {
      System.out.println(reverseVowels("hello"));
      System.out.println(reverseVowels("leetcode"));
      System.out.println(reverseVowels("ai"));
      System.out.println(reverseVowels("race a car"));
   }
}
