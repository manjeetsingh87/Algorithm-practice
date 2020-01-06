package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/28/19.
 */
public class ValidAnagrams {
   private static boolean isAnagram(String s, String t) {
      if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
         return true;
      }

      if (s == null || t == null) {
         return false;
      }

      if (s.length() != t.length()) {
         return false;
      }

      int[] chars = new int[26];
      for (int i = 0; i < s.length(); i++) {
         chars[s.charAt(i)-'a']++;
         chars[t.charAt(i)-'a']--;
      }

      for (int i = 0; i < chars.length; i++) {
         if (chars[i] != 0) {
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(isAnagram("anagram", "nagaram"));
      System.out.println(isAnagram("rat", "car"));
   }
}
